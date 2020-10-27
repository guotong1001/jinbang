package org.fm.constants;


import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fm.view.GlobleView;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    @JsonView(GlobleView.class)
    private T data;
    @JsonView(GlobleView.class)
    private Integer resp_code;
    @JsonView(GlobleView.class)
    private String resp_msg;

    public static <T> Result<T> succeed(String msg) {
        return succeedWith(null, CodeEnum.SUCCESS.getCode(),msg);
    }

    public static <T> Result<T> succeed(T model, String msg) {
        return succeedWith(model, CodeEnum.SUCCESS.getCode(),msg);
    }

    public static <T> Result<T> succeedWith(T datas, Integer code, String msg) {
        return new Result<T>(datas, code, msg);
    }

    public static <T> Result<T> failed(String msg) {
        return failedWith(null, CodeEnum.ERROR.getCode(), msg);
    }

    public static <T> Result<T> failed(T model, String msg) {
        return failedWith(model, CodeEnum.ERROR.getCode(), msg);
    }

    public static <T> Result<T> failedWith(T datas, Integer code, String msg) {
        return new Result<T>( datas, code, msg);
    }

}
