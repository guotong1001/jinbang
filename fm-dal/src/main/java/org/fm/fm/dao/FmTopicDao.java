package org.fm.fm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.fm.fm.bo.FmTopicBO;
import org.fm.util.RedisCache;

import java.util.List;
import java.util.Map;

/**
 * 题目表(FmTopic)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-11-13 14:59:41
 */
@Mapper
@CacheNamespace(implementation = RedisCache.class, eviction = RedisCache.class)
public interface FmTopicDao extends BaseMapper<FmTopicBO> {

    IPage<FmTopicBO> findPageForMap(IPage<FmTopicBO> page, @Param("map") Map<String, Object> filter);

    List<FmTopicBO> findListForMap(@Param("map") Map<String, Object> filter);

}