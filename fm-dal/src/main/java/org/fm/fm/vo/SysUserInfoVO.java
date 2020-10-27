package org.fm.fm.vo;

import lombok.Data;

/**
 * 系统用户信息表 (SysUserInfo)业务访问层
 *
 * @author Mr.zhang
 * @since 2020-09-23 11:19:24
 */
@Data
public class SysUserInfoVO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String verCode;

    /**
     * 验证码Key
     */
    private String verKey;

    @Override
    public String toString() {
        return "SysUserInfoVO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", verCode='" + verCode + '\'' +
                ", verKey='" + verKey + '\'' +
                '}';
    }
}
