package org.fm.bean;

/**
 * @ProjectName：fm
 * @ClassName：UrlEnum
 * @TODO：访问地址枚举类
 * @Auth：Mr.Zhang @Time：2020/9/22 10:11
 * @Remark：
 * @Version：1.0.0
 * @Copyright (C)：BookReflect
 */
public enum UrlEnum {

    //oauth2登录
    LOGIN_URL("/oauth/token"),
    ;

    private String url;

    UrlEnum(String url) {
        this.url = url;

    }


    public String getUrl() {
        return url;
    }
}
