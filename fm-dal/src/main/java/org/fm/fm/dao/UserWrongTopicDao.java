package org.fm.fm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.fm.fm.bo.UserWrongTopicBO;
import org.fm.util.RedisCache;

import java.util.List;
import java.util.Map;

/**
 * 用户错题关系表(UserWrongTopic)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-11-13 15:09:40
 */
@Mapper
@CacheNamespace(implementation = RedisCache.class, eviction = RedisCache.class)
public interface UserWrongTopicDao extends BaseMapper<UserWrongTopicBO> {

    IPage<UserWrongTopicBO> findPageForMap(IPage<UserWrongTopicBO> page, @Param("map") Map<String, Object> filter);

    List<UserWrongTopicBO> findListForMap(@Param("map") Map<String, Object> filter);

}