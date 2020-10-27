package org.fm.fm.bo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.fm.fm.entity.SysUserProjectRelation;

/**
 * 系统用户-项目关系表 (SysUserProjectRelation)表数据库访问层
 *
 * @author Mr.zhang
 * @since 2020-09-16 11:08:28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_project_relation")
public class SysUserProjectRelationBO extends SysUserProjectRelation {

}
