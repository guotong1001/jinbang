package org.fm.fm.bo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.fm.fm.entity.SysUserInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 系统用户信息表 (SysUserInfo)表数据库访问层
 *
 * @author Mr.zhang
 * @since 2020-09-16 11:08:28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_info")
public class SysUserInfoBO extends SysUserInfo implements Serializable {

    private static final long serialVersionUID = -276962274548453684L;
    @TableField(exist = false)
    private Set<SysRoleBO> sysRoleBOS = new HashSet<>();

    @TableField(exist = false)
    private List<Long> roleIds = new ArrayList<Long>();

}
