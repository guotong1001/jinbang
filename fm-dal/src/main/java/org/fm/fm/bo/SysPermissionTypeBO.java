package org.fm.fm.bo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.fm.fm.entity.SysPermissionType;

/**
 * 系统权限类型表 (SysPermissionType)表数据库访问层
 *
 * @author Mr.zhang
 * @since 2020-09-16 11:08:27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_permission_type")
public class SysPermissionTypeBO extends SysPermissionType {

}
