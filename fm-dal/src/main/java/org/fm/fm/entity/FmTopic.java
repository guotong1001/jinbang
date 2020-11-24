package org.fm.fm.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 题目表(FmTopic)表实体类
 *
 * @author Guoqing
 * @since 2020-11-13 14:59:42
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class FmTopic extends Model<FmTopic> {


    //主键    
    private Long id;

    //课程分类ID    
    private Long curriculumId;
    //题目类型 0选择1填空    
    private Integer type;
    //题目名    
    private String chapterName;
    //A    
    private String chapterA;
    //B    
    private String chapterB;
    //C    
    private String chapterC;
    //D    
    private String chapterD;
    //题目答案    
    private String chapterAnswer;
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

    public FmTopic() {
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