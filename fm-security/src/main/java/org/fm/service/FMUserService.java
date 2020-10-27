package org.fm.service;

import lombok.extern.slf4j.Slf4j;
import org.fm.bean.ResponseBean;
import org.fm.bean.ResponseEnum;
import org.fm.config.ServerConfig;
import org.fm.consts.HintConsts;
import org.fm.consts.StateCodeConsts;
import org.fm.fm.bo.SysUserInfoBO;
import org.fm.fm.service.SysUserInfoService;
import org.fm.fm.vo.SysUserInfoVO;
import org.fm.fm.vo.Token;
import org.fm.fm.vo.TokenVO;
import org.fm.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

import static org.fm.config.OAuth2Config.*;

/**
 * @ProjectName：fm
 * @ClassName：UserService
 * @TODO：
 * @Auth：Mr.Zhang @Time：2020/9/22 13:58
 * @Remark：
 * @Version：1.0.0
 * @Copyright (C)：BookReflect
 */
@Service("fMUserService")
@Slf4j
public class FMUserService {

    @Autowired
    private SysUserInfoService sysUserInfoService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${server.port}")
    private String serverPort;

    @Value("${project.token}")
    private String projectToken;
    /**
     * 用户登录
     * @param sysUserInfoVO
     * @return
     */
    public ResponseBean login(SysUserInfoVO sysUserInfoVO){
        log.info("登录---"+sysUserInfoVO.toString());
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("client_id", CLIENT_ID);
        paramMap.add("client_secret", CLIENT_SECRET);
        paramMap.add("username", sysUserInfoVO.getUsername());
        paramMap.add("password", sysUserInfoVO.getPassword());
        paramMap.add("grant_type", GRANT_TYPE[0]);
        Token token = null;
        try {
            //因为oauth2本身自带的登录接口是"/oauth/token"，并且返回的数据类型不能按我们想要的去返回
            //用restTemplate(HTTP客户端)进行一次转发到oauth2内部的登录接口
            // serverConfig.getUrl() + UrlEnum.LOGIN_URL.getUrl()
            System.out.println(serverConfig.getUrl() + serverPort + projectToken);
            token = restTemplate.postForObject(serverConfig.getUrl() + serverPort + projectToken, paramMap, Token.class);
            TokenVO tokenVO = redisUtil.get(token.getValue(), TokenVO.class);
            if(tokenVO != null){
                //登录的时候，判断该用户是否已经登录过了
                //如果redis里面已经存在该用户已经登录过了的信息
                //刷新一遍token信息，不然，它会返回上一次还未过时的token信息给你
                //不便于做单点维护
                token = oauthRefreshToken(tokenVO.getRefreshToken());
                redisUtil.deleteCache(tokenVO.getAccessToken());
            }
        } catch (RestClientException e) {
            Integer code = Integer.parseInt(e.getMessage().split(":")[0].trim());
            if(code == StateCodeConsts.STATE_401){
                return ResponseBean.error(code, HintConsts.LOGIN_FAILURE);
            }
            return ResponseBean.error(code, e.getMessage().split(":")[4].trim().split(",")[0].replaceAll("\"",""));
        }
        //拿到了登录成功后返回的token信息之后，我再进行一层封装，最后返回给前端的其实是LoginUserVO
        TokenVO tokenVO = new TokenVO();
        SysUserInfoBO sysUserInfoBO = sysUserInfoService.findByUsername(sysUserInfoVO.getUsername());
        tokenVO.setAccessToken(token.getValue());
        tokenVO.setTokenType(token.getTokenType());
        tokenVO.setRefreshToken(token.getRefreshToken().getValue());
        tokenVO.setRefreshTokenExpiration(token.getRefreshToken().getExpiration());
        //存储登录的用户
        redisUtil.set(tokenVO.getAccessToken(), tokenVO, TimeUnit.HOURS.toSeconds(1));
        return ResponseBean.success(tokenVO);
    }

    /**
     * oauth2客户端刷新token
     * @param refreshToken
     * @return
     */
    private Token oauthRefreshToken(String refreshToken) {
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("client_id", CLIENT_ID);
        paramMap.add("client_secret", CLIENT_SECRET);
        paramMap.add("refresh_token", refreshToken);
        paramMap.add("grant_type", GRANT_TYPE[1]);
        Token token = null;
        try {
            token = restTemplate.postForObject(serverConfig.getUrl() + serverPort + projectToken, paramMap, Token.class);
        } catch (RestClientException e) {
            try {
                //此处应该用自定义异常去返回，在这里我就不去具体实现了
                throw new Exception(ResponseEnum.REFRESH_TOKEN_INVALID.getMessage());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return token;
    }
}
