package org.fm.fm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.fm.fm.bo.UserCollectBO;
import org.fm.util.RedisCache;

import java.util.List;
import java.util.Map;

/**
 * 用户收藏关系表(UserCollect)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-11-13 15:09:16
 */
@Mapper
@CacheNamespace(implementation = RedisCache.class, eviction = RedisCache.class)
public interface UserCollectDao extends BaseMapper<UserCollectBO> {

    IPage<UserCollectBO> findPageForMap(IPage<UserCollectBO> page, @Param("map") Map<String, Object> filter);

    List<UserCollectBO> findListForMap(@Param("map") Map<String, Object> filter);

}