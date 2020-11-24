package org.fm.fm.bo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.fm.fm.entity.FmChapter;

/**
 * 课程章节表(FmChapter)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-11-13 14:49:21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("fm_chapter")
public class FmChapterBO extends FmChapter {

    private static final long serialVersionUID = -3832751360312099906L;

}