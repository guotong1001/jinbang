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
    private Long roleId;
    //权限
    private Long permissionId;

    public SysRolePermissionRelation() {
    }

    public SysRolePermissionRelation(Long roleId, Long permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
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
