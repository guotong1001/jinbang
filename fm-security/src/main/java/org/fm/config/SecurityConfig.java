package org.fm.config;

import lombok.extern.slf4j.Slf4j;
import org.fm.bean.FMUserInfo;
import org.fm.consts.SysConsts;
import org.fm.fm.bo.SysPermissionBO;
import org.fm.fm.bo.SysRoleBO;
import org.fm.fm.bo.SysUserInfoBO;
import org.fm.fm.service.SysUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName：fm
 * @ClassName：SecurityConfig
 * @TODO：Security核心配置
 * @Auth：Mr.Zhang @Time：2020/9/22 10:32
 * @Remark：
 * @Version：1.0.0
 * @Copyright (C)：BookReflect
 */
@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private SysUserInfoService sysUserInfoService;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new UserDetailsService(){
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                log.info("username:{}",username);
                SysUserInfoBO sysUserInfoBO = sysUserInfoService.findByUsername(username);
                if(sysUserInfoBO != null){
                    FMUserInfo fmUserInfo = new FMUserInfo();
                    fmUserInfo.setSysUserInfoBO(sysUserInfoBO);
                    fmUserInfo.setUsername(sysUserInfoBO.getUsername());
                    fmUserInfo.setPassword(sysUserInfoBO.getPassword());
                    fmUserInfo.setEnabled(getEnabled(sysUserInfoBO.getEnabled()));
                    List<GrantedAuthority> list = generateAuthorities(sysUserInfoBO);
                    fmUserInfo.setAuthorities(list);
                    return fmUserInfo;
                }else {//返回空
                    return null;
                }
            }
        };
    }

    /**
     * 定义权限列表
     * @param sysUserInfoBO
     * @return
     */
    private List<GrantedAuthority> generateAuthorities(SysUserInfoBO sysUserInfoBO){
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<String> sysRoles = new ArrayList<>();
        Set<SysRoleBO> sysRoleBOS = sysUserInfoBO.getSysRoleBOS();
        if(sysRoleBOS != null){
            for(SysRoleBO sysRoleBO: sysRoleBOS){
                sysRoles.add(sysRoleBO.getRoleName());
                Set<SysPermissionBO> permissionSet = sysRoleBO.getSysPermissionBOS();
                // 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
                for (SysPermissionBO sysPermissionBO: permissionSet) {
                    authorities.add(new SimpleGrantedAuthority(SysConsts.ROLE_PREFIX +sysPermissionBO.getPermissionCode()));
                }
            }
        }
        return authorities;
    }

    /**
     * 激活状态
     * @param enabled
     * @return
     */
    public boolean getEnabled(String enabled){
        if(enabled.equals("0"))
            return true;
        return false;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        //{bcrypt}$2a$10$akld0qTuEYZtkTcgffVhTe0FOSZYPYL8.ji9E98m26PVr5uCadDCe
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return new BCryptPasswordEncoder();
    }
}
