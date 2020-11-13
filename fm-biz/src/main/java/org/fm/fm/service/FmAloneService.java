package org.fm.fm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.fm.constants.PageResult;
import org.fm.fm.bo.FmAloneBO;

import java.util.List;
import java.util.Map;

/**
 * 单独视频音频表（与主分类内容不互通）(FmAlone)表服务接口
 *
 * @author Guoqing
 * @since 2020-11-13 14:47:14
 */
public interface FmAloneService extends IService<FmAloneBO> {

    /**
     * 分页查询 返回PageResult
     *
     * @param page
     * @param filter
     * @return
     */
    PageResult<FmAloneBO> findPageForMap(IPage<FmAloneBO> page, Map<String, Object> filter);


    /**
     * List查询
     *
     * @param filter
     * @return
     */
    List<FmAloneBO> findListForMap(Map<String, Object> filter);

}