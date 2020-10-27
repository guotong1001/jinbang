package org.fm.fm.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 系统角色权限表 (SysRolePermissionRelation)表实体类
 *
 * @author Mr.zhang
 * @since 2020-09-23 11:23:20
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRolePermissionRelation extends Model<SysRolePermissionRelation> {
    //角色
    private Integer roleId;
    //权限
    private Integer permissionId;

    public SysRolePermissionRelation() {
    }

    public SysRolePermissionRelation(Integer roleId, Integer permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }
}
