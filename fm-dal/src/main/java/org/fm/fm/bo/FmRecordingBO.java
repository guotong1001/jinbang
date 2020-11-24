package org.fm.fm.bo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.fm.fm.entity.FmRecording;

/**
 * 录音表(FmRecording)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-11-13 14:56:05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("fm_recording")
public class FmRecordingBO extends FmRecording {

    private static final long serialVersionUID = 1778407175913666126L;

}