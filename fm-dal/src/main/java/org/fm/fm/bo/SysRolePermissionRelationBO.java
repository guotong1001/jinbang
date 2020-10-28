package org.fm.fm.bo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.fm.fm.entity.SysRolePermissionRelation;

/**
 * 系统角色-权限关系表 (SysRolePermissionRelation)表数据库访问层
 *
 * @author Mr.zhang
 * @since 2020-09-16 11:08:28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role_permission_relation")
public class SysRolePermissionRelationBO extends SysRolePermissionRelation {

    private static final long serialVersionUID = 8480051417525159133L;

    public SysRolePermissionRelationBO() {
    }

    public SysRolePermissionRelationBO(Long roleId, Long permissionId) {
        super(roleId, permissionId);
    }
}
