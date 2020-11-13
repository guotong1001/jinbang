package org.fm.fm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.fm.constants.PageResult;
import org.fm.fm.bo.UserWrongTopicBO;

import java.util.List;
import java.util.Map;

/**
 * 用户错题关系表(UserWrongTopic)表服务接口
 *
 * @author Guoqing
 * @since 2020-11-13 15:09:48
 */
public interface UserWrongTopicService extends IService<UserWrongTopicBO> {

    /**
     * 分页查询 返回PageResult
     *
     * @param page
     * @param filter
     * @return
     */
    PageResult<UserWrongTopicBO> findPageForMap(IPage<UserWrongTopicBO> page, Map<String, Object> filter);


    /**
     * List查询
     *
     * @param filter
     * @return
     */
    List<UserWrongTopicBO> findListForMap(Map<String, Object> filter);

}