package org.fm.fm.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户购买课程表(UserChapter)表实体类
 *
 * @author Guoqing
 * @since 2020-11-13 15:08:48
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class UserChapter extends Model<UserChapter> {

    private static final long serialVersionUID = -33136856186391151L;

    //主键    
    private Long id;

    //用户ID    
    private Long userId;
    //内容ID    
    private Long contentId;
    //创建时间    
    private Date createTime;
    //备注    
    private String remark;

    public UserChapter() {
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