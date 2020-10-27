package org.fm.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

/**
 * @ProjectName：fm
 * @ClassName：ResponseVO
 * @TODO：
 * @Auth：Mr.Zhang @Time：2020/9/22 11:28
 * @Remark：
 * @Version：1.0.0
 * @Copyright (C)：BookReflect
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBean<T> implements Serializable {

    private static final long serialVersionUID = -437839076132402939L;

    /**
     * 异常码
     */
    private long code;

    /**
     * 描述
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    public ResponseBean() {}

    public ResponseBean(long code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public ResponseBean(long code, String msg, T data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    public ResponseBean(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }

    public ResponseBean(ResponseEnum responseEnum, T data) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
        this.data = data;
    }

    public static ResponseBean success(){
        return new ResponseBean(ResponseEnum.SUCCESS);
    }

    public static <T> ResponseBean<T> success(T data){
        return new ResponseBean<T>(ResponseEnum.SUCCESS, data);
    }

    public static <T> ResponseBean<T> success(long code, String msg){
        return new ResponseBean<T>(code, msg);
    }

    public static ResponseBean error(long code, String msg){
        return new ResponseBean(code,msg);
    }

    public static ResponseBean error(ResponseEnum responseEnum){
        return new ResponseBean(responseEnum);
    }

    public static ResponseBean error(ResponseEnum responseEnum, Object data){
        return new ResponseBean<Object>(responseEnum, data);
    }

    public static ResponseBean errorParams(String msg){
        return new ResponseBean(ResponseEnum.INCORRECT_PARAMS.getCode(), msg);
    }

    public static ResponseBean error(BindingResult result, MessageSource messageSource) {
        StringBuffer msg = new StringBuffer();
        //获取错误字段集合
        List<FieldError> fieldErrors = result.getFieldErrors();
        //获取本地locale,zh_CN
        Locale currentLocale = LocaleContextHolder.getLocale();
        //遍历错误字段获取错误消息
        for (FieldError fieldError : fieldErrors) {
            //获取错误信息
            String errorMessage = messageSource.getMessage(fieldError, currentLocale);
            //添加到错误消息集合内
            msg.append(fieldError.getField() + "：" + errorMessage + " , ");
        }
        return ResponseBean.error(ResponseEnum.INCORRECT_PARAMS, msg.toString());
    }
}
