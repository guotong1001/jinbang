package org.fm.filter;

import org.fm.exception.FMVerCodeException;
import org.fm.handler.FMAuthExceptionHandler;
import org.fm.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName：fm
 * @ClassName：SystemCaptchaFilter
 * @TODO：自定义系统验证码拦截
 * @Auth：Mr.Zhang @Time：2020/9/24 14:50
 * @Remark：
 * @Version：1.0.0
 * @Copyright (C)：BookReflect
 */
@Component
public class FMSystemCaptchaFilter extends OncePerRequestFilter {

    @Value("${project.ver-code}")
    private String verCode;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private FMAuthExceptionHandler fmAuthExceptionHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getRequestURI().equals(verCode+"/user/login")) {
            try {
                checkCaptcha(request);
            } catch (AuthenticationException exception) {
                //失败调用我们的自定义失败处理器
                fmAuthExceptionHandler.onAuthenticationFailure(request, response, exception);
                return ;
            }
        }
        filterChain.doFilter(request,response);
    }

    /**
     * 验证验证码情况，不同情况抛出不同异常
     * @param request
     */
    private void checkCaptcha( HttpServletRequest request) throws AuthenticationException {

        String verCode = request.getParameter("verCode");
        String verKey = request.getParameter("verKey");
        if(verCode == null || verKey == null)
            throw new FMVerCodeException("验证码的值不能为空");

        String captchaCode = (String) redisUtil.getValueByKey(verKey);

        if(!verCode.trim().equalsIgnoreCase(captchaCode))
            throw new FMVerCodeException("验证码不匹配");

        redisUtil.deleteCache(verKey);
    }
}
