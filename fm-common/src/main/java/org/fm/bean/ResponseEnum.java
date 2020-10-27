package org.fm.bean;

import com.baomidou.mybatisplus.extension.api.IErrorCode;
import lombok.ToString;

/**
 * @ProjectName：fm
 * @ClassName：ResponseEnum
 * @TODO：数据信息状态枚举类
 * @Auth：Mr.Zhang @Time：2020/9/22 10:09
 * @Remark：
 * @Version：1.0.0
 * @Copyright (C)：BookReflect
 */
@ToString
public enum ResponseEnum implements IErrorCode {

    /**
     * 0 表示返回成功
     */
    SUCCESS(200,"成功"),

    /**
     * 表示接口调用方异常提示
     */
    ACCESS_TOKEN_INVALID(1001,"access_token无效"),
    REFRESH_TOKEN_INVALID(1002,"refresh_token无效"),
    INSUFFICIENT_PERMISSIONS(1003,"该用户权限不足以访问该资源接口"),
    UNAUTHORIZED(1004,"访问此资源需要完全的身份验证"),
    ACCESS_VER_CODE(1005,"验证码错误"),


    /**
     * 500 表示用户提示信息
     */
    INCORRECT_PARAMS(500, "参数不正确"),
    ;
    private long code;
    private String message;

    ResponseEnum(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return message;
    }

    public String getMessage() {
        return message;
    }

}
