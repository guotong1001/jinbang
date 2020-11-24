package org.fm.fm.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 单独视频音频表（与主分类内容不互通）(FmAlone)表实体类
 *
 * @author Guoqing
 * @since 2020-11-13 14:46:55
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class FmAlone extends Model<FmAlone> {


    //主键    
    private Long id;

    //内容名    
    private String chapterName;
    //内容介绍    
    private String chapterIntroduce;
    //内容地址    
    private String chapterPath;
    //类型 （0视频1音频）    
    private Integer type;
    //收费类型 （0免费1vip2单独收费）    
    private Integer vipType;
    //创建时间    
    private Date createTime;
    //更新时间    
    private Date updateTime;
    //逻辑删除 （0启用|1删除）    
    private Integer isDelete;
    //备注    
    private String remark;

    public FmAlone() {
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