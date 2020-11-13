package org.fm.fm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.fm.constants.PageResult;
import org.fm.fm.bo.FmChapterBO;

import java.util.List;
import java.util.Map;

/**
 * 课程章节表(FmChapter)表服务接口
 *
 * @author Guoqing
 * @since 2020-11-13 14:49:28
 */
public interface FmChapterService extends IService<FmChapterBO> {

    /**
     * 分页查询 返回PageResult
     *
     * @param page
     * @param filter
     * @return
     */
    PageResult<FmChapterBO> findPageForMap(IPage<FmChapterBO> page, Map<String, Object> filter);


    /**
     * List查询
     *
     * @param filter
     * @return
     */
    List<FmChapterBO> findListForMap(Map<String, Object> filter);

}