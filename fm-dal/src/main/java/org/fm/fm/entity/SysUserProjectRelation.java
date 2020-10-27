package org.fm.fm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 系统用户-项目关系表 (SysUserProjectRelation)表实体类
 *
 * @author Mr.zhang
 * @since 2020-09-16 11:07:02
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserProjectRelation extends Model<SysUserProjectRelation> {
    //用户ID
    @TableId(value = "user_id",type = IdType.INPUT)
    private Integer userId;
    //项目ID
    @TableId(value = "projec_id",type = IdType.INPUT)
    private Integer projectId;

    public SysUserProjectRelation() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
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
