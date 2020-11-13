package org.fm.fm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.fm.constants.PageResult;
import org.fm.fm.bo.FmRecordingBO;

import java.util.List;
import java.util.Map;

/**
 * 录音表(FmRecording)表服务接口
 *
 * @author Guoqing
 * @since 2020-11-13 14:56:11
 */
public interface FmRecordingService extends IService<FmRecordingBO> {

    /**
     * 分页查询 返回PageResult
     *
     * @param page
     * @param filter
     * @return
     */
    PageResult<FmRecordingBO> findPageForMap(IPage<FmRecordingBO> page, Map<String, Object> filter);


    /**
     * List查询
     *
     * @param filter
     * @return
     */
    List<FmRecordingBO> findListForMap(Map<String, Object> filter);

}