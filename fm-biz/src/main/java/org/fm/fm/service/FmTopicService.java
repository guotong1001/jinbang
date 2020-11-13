package org.fm.fm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.fm.constants.PageResult;
import org.fm.fm.bo.FmTopicBO;

import java.util.List;
import java.util.Map;

/**
 * 题目表(FmTopic)表服务接口
 *
 * @author Guoqing
 * @since 2020-11-13 14:59:49
 */
public interface FmTopicService extends IService<FmTopicBO> {

    /**
     * 分页查询 返回PageResult
     *
     * @param page
     * @param filter
     * @return
     */
    PageResult<FmTopicBO> findPageForMap(IPage<FmTopicBO> page, Map<String, Object> filter);


    /**
     * List查询
     *
     * @param filter
     * @return
     */
    List<FmTopicBO> findListForMap(Map<String, Object> filter);

}