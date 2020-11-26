package org.fm.fm.bo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.fm.fm.entity.FmAd;

/**
 * 广告表(FmAd)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-11-26 11:36:54
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("fm_ad")
public class FmAdBO extends FmAd {

    private static final long serialVersionUID = 628694441180337790L;

}