package org.fm.fm.bo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.fm.fm.entity.SysUserRoleRelation;

/**
 * 系统用户-角色关系表 (SysUserRoleRelation)表数据库访问层
 *
 * @author Mr.zhang
 * @since 2020-09-16 11:08:29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_role_relation")
public class SysUserRoleRelationBO extends SysUserRoleRelation {

    private static final long serialVersionUID = -8072459703366128540L;

}
