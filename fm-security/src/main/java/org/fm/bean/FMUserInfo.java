package org.fm.bean;

import lombok.Setter;
import org.fm.fm.bo.SysUserInfoBO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * @ProjectName：fm
 * @ClassName：FMUserInfo
 * @TODO：自定义userDetail 关联security oauth2
 * @Auth：Mr.Zhang @Time：2020/9/23 9:01
 * @Remark：
 * @Version：1.0.0
 * @Copyright (C)：BookReflect
 */
@Setter
public class FMUserInfo implements UserDetails, Serializable {

    private static final long serialVersionUID = -8478114427891717226L;

    /**
     * 用户信息
     */
    private SysUserInfoBO sysUserInfoBO;

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 账户生效
     */
    private boolean accountNonExpired = true;
    /**
     * 账户锁定
     */
    private boolean accountNonLocked = true;
    /**
     * 凭证生效
     */
    private boolean credentialsNonExpired = true;
    /**
     * 激活状态
     */
    private boolean enabled = true;
    /**
     * 权限列表
     */
    private Collection<GrantedAuthority> authorities;

    public SysUserInfoBO getSysUserInfoBO() {
        return sysUserInfoBO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}
