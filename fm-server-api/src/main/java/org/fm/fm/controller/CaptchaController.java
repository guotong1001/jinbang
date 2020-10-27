package org.fm.fm.controller;

import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.SpecCaptcha;
import lombok.extern.slf4j.Slf4j;
import org.fm.bean.ResponseBean;
import org.fm.constants.BaseController;
import org.fm.util.RedisUtil;
import org.fm.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName：fm
 * @ClassName：CaptchaController
 * @TODO：
 * @Auth：Mr.Zhang @Time：2020/9/24 13:39
 * @Remark：
 * @Version：1.0.0
 * @Copyright (C)：BookReflect
 */
@RestController
@Slf4j
public class CaptchaController extends BaseController {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 验证码
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @GetMapping("/captcha")
    public ResponseBean captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ArithmeticCaptcha captcha = new ArithmeticCaptcha(130, 48);
        captcha.setLen(3);  // 几位数运算，默认是两位
        captcha.getArithmeticString();  // 获取运算的公式：3+2=?
        String verCode = captcha.text();  // 获取运算的结果：5

        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
//        String verCode = specCaptcha.text().toLowerCase();
        String key = UUIDUtil.uuid();
        // 存入redis并设置过期时间为60秒
        redisUtil.set(key, verCode, 60);
        Map<String, Object> map = new HashMap<>();
        map.put("key", key);
        map.put("image", captcha.toBase64());
        map.put("code", verCode);
        // 将key和base64返回给前端
        return success(map);
    }
}
