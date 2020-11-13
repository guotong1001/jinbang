package org.fm.fm.bo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.fm.fm.entity.FmTopic;

/**
 * 题目表(FmTopic)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-11-13 14:59:42
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("fm_topic")
public class FmTopicBO extends FmTopic {

}