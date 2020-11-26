package org.fm.fm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.fm.constants.PageResult;
import org.fm.fm.bo.FmAdBO;

import java.util.List;
import java.util.Map;

/**
 * 广告表(FmAd)表服务接口
 *
 * @author Guoqing
 * @since 2020-11-26 11:37:03
 */
public interface FmAdService extends IService<FmAdBO> {

    /**
     * 分页查询 返回PageResult
     *
     * @param page
     * @param filter
     * @return
     */
    PageResult<FmAdBO> findPageForMap(IPage<FmAdBO> page, Map<String, Object> filter);


    /**
     * List查询
     *
     * @param filter
     * @return
     */
    List<FmAdBO> findListForMap(Map<String, Object> filter);

}