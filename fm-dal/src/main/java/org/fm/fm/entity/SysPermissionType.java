package org.fm.fm.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统权限类型表 (SysPermissionType)表实体类
 *
 * @author Mr.zhang
 * @since 2020-09-16 11:07:00
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class SysPermissionType extends Model<SysPermissionType> {
    //编号
    @TableId(type = IdType.AUTO)
    private Integer id;
    //类型编码
    private String typeCode;
    //类型简介
    private String typeIntro;
    //逻辑删除（0启用|1删除）
    @TableLogic
    private Integer isDelete;
    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    //备注
    private String remark;

    public SysPermissionType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeIntro() {
        return typeIntro;
    }

    public void setTypeIntro(String typeIntro) {
        this.typeIntro = typeIntro;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
