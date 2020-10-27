package org.fm.fm.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统权限表 (SysPermission)表实体类
 *
 * @author Mr.zhang
 * @since 2020-09-23 11:22:42
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class SysPermission extends Model<SysPermission> {
    //主键
    private Integer id;
    //权限编码
    private String permissionCode;
    //权限类型 （0系统|1项目|2菜单|3功能）
    private String permissionType;
    //权限描述
    private String permissionInfo;
    //创建时间
    private Date createTime;
    //逻辑删除 （0启用|1删除）
    @TableLogic
    private Integer isDelete;
    //备注
    private String remark;

    public SysPermission() {
    }

    public SysPermission(String permissionCode, String permissionType, String permissionInfo, Date createTime) {
        this.permissionCode = permissionCode;
        this.permissionType = permissionType;
        this.permissionInfo = permissionInfo;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
    }

    public String getPermissionInfo() {
        return permissionInfo;
    }

    public void setPermissionInfo(String permissionInfo) {
        this.permissionInfo = permissionInfo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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
