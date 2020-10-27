package org.fm.handler;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.fm.bean.ResponseEnum;
import org.fm.bean.ResponseBean;
import org.fm.exception.FMVerCodeException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName：fm
 * @ClassName：CustomAuthExceptionHandler
 * @TODO：自定义未授权 token无效 权限不足返回信息处理类
 * @Auth：Mr.Zhang @Time：2020/9/22 10:05
 * @Remark：
 * @Version：1.0.0
 * @Copyright (C)：BookReflect
 */
@Component
@Slf4j
public class FMAuthExceptionHandler implements AuthenticationEntryPoint, AccessDeniedHandler {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        Throwable cause = authException.getCause();
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        // CORS "pre-flight" request
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Cache-Control","no-cache");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        response.addHeader("Access-Control-Max-Age", "1800");
        if (cause instanceof InvalidTokenException) {
            log.error("InvalidTokenException : {}",cause.getMessage());
            //Token无效
            response.getWriter().write(JSON.toJSONString(ResponseBean.error(ResponseEnum.ACCESS_TOKEN_INVALID)));
        } else {
            log.error("AuthenticationException : NoAuthentication");
            //资源未授权
            response.getWriter().write(JSON.toJSONString(ResponseBean.error(ResponseEnum.UNAUTHORIZED)));
        }

    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Cache-Control","no-cache");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        response.addHeader("Access-Control-Max-Age", "1800");
        //访问资源的用户权限不足
        log.error("AccessDeniedException : {}",accessDeniedException.getMessage());
        response.getWriter().write(JSON.toJSONString(ResponseBean.error(ResponseEnum.INSUFFICIENT_PERMISSIONS)));
    }

    /**
     * 验证码处理
     * @param request
     * @param response
     * @param exception
     * @throws IOException
     * @throws ServletException
     */
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (exception instanceof FMVerCodeException) {
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_OK);
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Cache-Control","no-cache");
            response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
            response.addHeader("Access-Control-Max-Age", "1800");
            //访问资源的用户权限不足
            log.error("FMVerCodeException : {}",exception.getMessage());
            response.getWriter().write(JSON.toJSONString(ResponseBean.error(ResponseEnum.ACCESS_VER_CODE)));
        }
    }
}
