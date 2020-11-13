package org.fm.fm.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程分类表(FmCurriculum)表实体类
 *
 * @author Guoqing
 * @since 2020-11-13 14:49:49
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class FmCurriculum extends Model<FmCurriculum> {

    private static final long serialVersionUID = 519366796547794684L;

    //主键    
    private Long id;

    //第一分类    
    private Integer oneType;
    //第二分类    
    private Integer twoType;
    //第三分类    
    private Integer threeType;
    //第四分类    
    private Integer fourType;
    //创建时间    
    private Date createTime;
    //更新时间    
    private Date updateTime;
    //逻辑删除 （0启用|1删除）    
    private Integer isDelete;
    //备注    
    private String remark;

    public FmCurriculum() {
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