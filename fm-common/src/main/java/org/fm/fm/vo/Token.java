package org.fm.fm.vo;

import org.fm.bean.RefreshTokenBean;

import java.util.List;

/**
 * @ProjectName：fm
 * @ClassName：UrlEnum
 * @TODO：oauth2客户端token参数
 * @Auth：Mr.Zhang @Time：2020/9/22 11:11
 * @Remark：
 * @Version：1.0.0
 * @Copyright (C)：BookReflect
 */
public class Token {

    /**
     * 过期时间
     */
    private String expiration;
    /**
     * 是否过期
     */
    private boolean expired;
    /**
     * 过期时限
     */
    private int expiresIn;
    /**
     * refreshToken对象
     */
    private RefreshTokenBean refreshToken;

    /**
     * token类型
     */
    private String tokenType;

    /**
     * access_token值
     */
    private String value;

    /**
     * 使用范围
     */
    private List<String> scope;


    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public RefreshTokenBean getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(RefreshTokenBean refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> getScope() {
        return scope;
    }

    public void setScope(List<String> scope) {
        this.scope = scope;
    }
}
