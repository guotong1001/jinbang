package org.fm.fm.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 广告表(FmAd)表实体类
 *
 * @author Guoqing
 * @since 2020-11-26 11:36:54
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class FmAd extends Model<FmAd> {


    //主键    
    private Long id;

    //广告名    
    private String adName;
    //广告地址    
    private String adPath;
    //创建时间    
    private Date createTime;
    //更新时间    
    private Date updateTime;
    //逻辑删除 （0启用|1删除）    
    private Integer isDelete;
    //备注    
    private String remark;

    public FmAd() {
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