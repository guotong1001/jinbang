package org.fm.fm.bo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.fm.fm.entity.UserWrongTopic;

/**
 * 用户错题关系表(UserWrongTopic)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-11-13 15:09:40
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_wrong_topic")
public class UserWrongTopicBO extends UserWrongTopic {

    private static final long serialVersionUID = 6996418107248786100L;

}