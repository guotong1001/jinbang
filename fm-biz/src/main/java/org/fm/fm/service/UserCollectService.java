package org.fm.fm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.fm.constants.PageResult;
import org.fm.fm.bo.UserCollectBO;

import java.util.List;
import java.util.Map;

/**
 * 用户收藏关系表(UserCollect)表服务接口
 *
 * @author Guoqing
 * @since 2020-11-19 09:32:49
 */
public interface UserCollectService extends IService<UserCollectBO> {

    /**
     * 分页查询 返回PageResult
     *
     * @param page
     * @param filter
     * @return
     */
    PageResult<UserCollectBO> findPageForMap(IPage<UserCollectBO> page, Map<String, Object> filter);


    /**
     * List查询
     *
     * @param filter
     * @return
     */
    List<UserCollectBO> findListForMap(Map<String, Object> filter);

}