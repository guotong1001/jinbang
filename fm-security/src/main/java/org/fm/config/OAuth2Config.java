package org.fm.config;

//import org.fm.filter.FMSystemCaptchaFilter;

import org.fm.filter.FMSystemCaptchaFilter;
import org.fm.handler.FMAuthExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName：fm
 * @ClassName：OAuth2Config
 * @TODO：OAuth2服务器配置
 * @Auth：Mr.Zhang @Time：2020/9/22 10:03
 * @Remark：
 * @Version：1.0.0
 * @Copyright (C)：BookReflect
 */
@Configuration
public class OAuth2Config {

    public static final String ROLE_ADMIN = "ADMIN";
    //访问客户端密钥
    public static final String CLIENT_SECRET = "fm_1_0_0";
    //访问客户端ID
    public static final String CLIENT_ID ="client_1";
    //鉴权模式
    public static final String GRANT_TYPE[] = {"password","refresh_token"};

    /**
     * @description 资源服务器
     */
    @Configuration
    @EnableResourceServer
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        @Autowired
        private FMAuthExceptionHandler fmAuthExceptionHandler;

        @Autowired
        private FMSystemCaptchaFilter fmSystemCaptchaFilter;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources.stateless(false)
                    .accessDeniedHandler(fmAuthExceptionHandler)
                    .authenticationEntryPoint(fmAuthExceptionHandler);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .and()
                    //请求权限配置
                    .authorizeRequests()
                    //下边的路径放行,不需要经过认证
                    .antMatchers("/oauth/*", "/captcha", "/sysUserInfo/user/login").permitAll()
//                    //OPTIONS请求不需要鉴权
//                    .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                    //用户的增删改接口只允许管理员访问
//                    .antMatchers(HttpMethod.POST, "/sysUserInfo/user").hasAnyAuthority(ROLE_ADMIN)
//                    .antMatchers(HttpMethod.PUT, "/sysUserInfo/user").hasAnyAuthority(ROLE_ADMIN)
//                    .antMatchers(HttpMethod.DELETE, "/sysUserInfo/user").hasAnyAuthority(ROLE_ADMIN)
//                    //获取角色 权限列表接口只允许系统管理员及高级用户访问
//                    .antMatchers(HttpMethod.GET, "/sysUserInfo/role").hasAnyAuthority(ROLE_ADMIN)
                    //其余接口没有角色限制，但需要经过认证，只要携带token就可以放行
                    .anyRequest()
                    .authenticated();

            http.addFilterBefore(fmSystemCaptchaFilter, UsernamePasswordAuthenticationFilter.class);
        }
    }

    /**
     * @description 认证授权服务器
     */
    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private RedisConnectionFactory connectionFactory;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//            String finalSecret = "{bcrypt}" + new BCryptPasswordEncoder().encode(CLIENT_SECRET);
            String finalSecret = passwordEncoder.encode(CLIENT_SECRET);
            //配置客户端，使用密码模式验证鉴权
            clients.inMemory()
                    .withClient(CLIENT_ID)
                    //密码模式及refresh_token模式
                    .authorizedGrantTypes(GRANT_TYPE[0], GRANT_TYPE[1])
                    .scopes("all")
                    .secret(finalSecret);
        }

        @Bean
        public RedisTokenStore redisTokenStore() {
            return new RedisTokenStore(connectionFactory);
        }

        /**
         * @description token及用户信息存储到redis，当然也可以存储在当前的服务内存，不推荐
         * @param endpoints
         */
        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
            //token信息存到服务内存
            /*endpoints.tokenStore(new InMemoryTokenStore())
                    .authenticationManager(authenticationManager);*/
            //token信息存到redis
            endpoints.tokenStore(redisTokenStore()).authenticationManager(authenticationManager);
            //配置TokenService参数
            DefaultTokenServices tokenService = new DefaultTokenServices();
            tokenService.setTokenStore(endpoints.getTokenStore());
            tokenService.setSupportRefreshToken(true);
            tokenService.setClientDetailsService(endpoints.getClientDetailsService());
            tokenService.setTokenEnhancer(endpoints.getTokenEnhancer());
            //1小时
            tokenService.setAccessTokenValiditySeconds((int) TimeUnit.HOURS.toSeconds(1));
            //1小时
            tokenService.setRefreshTokenValiditySeconds((int) TimeUnit.HOURS.toSeconds(1));
            tokenService.setReuseRefreshToken(false);
            endpoints.tokenServices(tokenService);
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
            //允许表单认证
            oauthServer.allowFormAuthenticationForClients().tokenKeyAccess("isAuthenticated()")
                    .checkTokenAccess("permitAll()");
        }
    }

}
