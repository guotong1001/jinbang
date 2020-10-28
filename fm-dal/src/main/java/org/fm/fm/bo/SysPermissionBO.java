package org.fm.fm.bo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.fm.fm.entity.SysPermission;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 系统权限表 (SysPermission)表数据库访问层
 *
 * @author Mr.zhang
 * @since 2020-09-16 11:08:27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_permission")
public class SysPermissionBO extends SysPermission {

    private static final long serialVersionUID = -7977946540557964306L;
    @TableField(exist = false)
    private Set<SysPermissionBO> sysPermissionBOS = new HashSet<>();

    public SysPermissionBO() {
    }

    public SysPermissionBO(String permissionCode, String permissionType, String permissionInfo, Date createTime) {
        super(permissionCode, permissionType, permissionInfo, createTime);
    }

    public Set<SysPermissionBO> getSysPermissionBOS() {
        return sysPermissionBOS;
    }

    public void setSysPermissionBOS(Set<SysPermissionBO> sysPermissionBOS) {
        this.sysPermissionBOS = sysPermissionBOS;
    }
}
