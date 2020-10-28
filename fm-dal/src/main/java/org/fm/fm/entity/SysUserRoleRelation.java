package org.fm.fm.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 系统用户角色表 (SysUserRoleRelation)表实体类
 *
 * @author Mr.zhang
 * @since 2020-09-23 11:19:25
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserRoleRelation extends Model<SysUserRoleRelation> {
    //用户
    private Long userId;
    //角色
    private Long roleId;

    public SysUserRoleRelation() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.userId;
    }
}
