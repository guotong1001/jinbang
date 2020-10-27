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
    private Integer userId;
    //角色
    private Integer roleId;

    public SysUserRoleRelation() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
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
