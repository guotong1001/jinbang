package org.fm.fm.bo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.fm.fm.entity.FmCurriculum;

/**
 * 课程分类表(FmCurriculum)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-11-13 14:49:49
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("fm_curriculum")
public class FmCurriculumBO extends FmCurriculum {

    private static final long serialVersionUID = -880277799127911089L;

}