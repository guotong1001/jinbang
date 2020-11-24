package org.fm.fm.bo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.fm.fm.entity.UserCollect;

/**
 * 用户收藏关系表(UserCollect)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-11-19 09:33:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_collect")
public class UserCollectBO extends UserCollect {

    private static final long serialVersionUID = 8986035413263507419L;

}