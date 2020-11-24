package org.fm.fm.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户收藏关系表(UserCollect)表实体类
 *
 * @author Guoqing
 * @since 2020-11-19 09:33:02
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class UserCollect extends Model<UserCollect> {


    //主键    
    private Long id;

    //用户ID    
    private Long userId;
    //内容ID    
    private Long contentId;
    //内容类别（1视频，2音频，3考题）    
    private Integer contentType;
    //创建时间    
    private Date createTime;
    //逻辑删除 （0启用|1删除）    
    private Integer isDelete;
    //备注    
    private String remark;

    public UserCollect() {
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