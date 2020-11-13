package org.fm.fm.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 录音表(FmRecording)表实体类
 *
 * @author Guoqing
 * @since 2020-11-13 14:56:04
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class FmRecording extends Model<FmRecording> {

    private static final long serialVersionUID = 524361469196026378L;

    //主键    
    private Long id;

    //用户ID    
    private Long userId;
    //根源ID    
    private Long sourceId;
    //录音文件链接    
    private String recording;
    //创建时间    
    private Date createTime;
    //更新时间    
    private Date updateTime;
    //逻辑删除 （0启用|1删除）    
    private Integer isDelete;
    //备注    
    private String remark;

    public FmRecording() {
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