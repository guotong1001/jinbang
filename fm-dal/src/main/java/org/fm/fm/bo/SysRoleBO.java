package org.fm.fm.bo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.fm.fm.entity.SysRole;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 系统角色表 (SysRole)表数据库访问层
 *
 * @author Mr.zhang
 * @since 2020-09-16 11:08:27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role")
public class SysRoleBO extends SysRole implements Serializable {

    private static final long serialVersionUID = 5228281388986911237L;
    @TableField(exist = false)
    private Set<SysPermissionBO> sysPermissionBOS = new HashSet<>();

    @TableField(exist = false)
    private List<Long> permissionIds = new ArrayList<Long>();

}
