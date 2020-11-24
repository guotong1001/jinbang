package org.fm.fm.bo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.fm.fm.entity.UserChapter;

/**
 * 用户购买课程表(UserChapter)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-11-13 15:08:48
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_chapter")
public class UserChapterBO extends UserChapter {

    private static final long serialVersionUID = 5332115781203149934L;

}