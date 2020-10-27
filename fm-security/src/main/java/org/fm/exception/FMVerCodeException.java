package org.fm.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @ProjectName：fm
 * @ClassName：FMVerCodeException
 * @TODO：
 * @Auth：Mr.Zhang @Time：2020/9/24 15:00
 * @Remark：
 * @Version：1.0.0
 * @Copyright (C)：BookReflect
 */
public class FMVerCodeException extends AuthenticationException {

    public FMVerCodeException(String msg) {
        super(msg);
    }
}
