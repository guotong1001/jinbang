package org.fm.fm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.fm.constants.PageResult;
import org.fm.fm.bo.UserChapterBO;

import java.util.List;
import java.util.Map;

/**
 * 用户购买课程表(UserChapter)表服务接口
 *
 * @author Guoqing
 * @since 2020-11-13 15:08:55
 */
public interface UserChapterService extends IService<UserChapterBO> {

    /**
     * 分页查询 返回PageResult
     *
     * @param page
     * @param filter
     * @return
     */
    PageResult<UserChapterBO> findPageForMap(IPage<UserChapterBO> page, Map<String, Object> filter);


    /**
     * List查询
     *
     * @param filter
     * @return
     */
    List<UserChapterBO> findListForMap(Map<String, Object> filter);

}