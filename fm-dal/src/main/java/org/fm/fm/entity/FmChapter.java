package org.fm.fm.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程章节表(FmChapter)表实体类
 *
 * @author Guoqing
 * @since 2020-11-13 14:49:21
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class FmChapter extends Model<FmChapter> {


    //主键    
    private Long id;

    //课程分类ID    
    private Long curriculumId;
    //章节名    
    private String chapterName;
    //章节介绍    
    private String chapterIntroduce;
    //章节地址    
    private String chapterPath;
    //类型 （0视频1音频）    
    private Integer type;
    //收费类型 （0免费1vip2单独收费）    
    private Integer vipType;
    //地区类型 （0外国，1国内，2其他）    
    private Integer isInland;
    //创建时间    
    private Date createTime;
    //更新时间    
    private Date updateTime;
    //逻辑删除 （0启用|1删除）    
    private Integer isDelete;
    //备注    
    private String remark;

    public FmChapter() {
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