package org.fm.fm.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户错题关系表(UserWrongTopic)表实体类
 *
 * @author Guoqing
 * @since 2020-11-13 15:09:40
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class UserWrongTopic extends Model<UserWrongTopic> {

    private static final long serialVersionUID = -84883837546753061L;

    //主键    
    private Long id;

    //用户ID    
    private Long userId;
    //错题ID    
    private Long topicId;
    //创建时间    
    private Date createTime;
    //逻辑删除 （0启用|1删除）    
    private Integer isDelete;
    //备注    
    private String remark;

    public UserWrongTopic() {
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