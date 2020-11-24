package org.fm.fm.bo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.fm.fm.entity.FmAlone;

/**
 * 单独视频音频表（与主分类内容不互通）(FmAlone)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-11-13 14:46:55
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("fm_alone")
public class FmAloneBO extends FmAlone {

    private static final long serialVersionUID = -392397869214908316L;

}