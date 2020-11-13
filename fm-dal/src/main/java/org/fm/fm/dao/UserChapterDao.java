package org.fm.fm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.fm.fm.bo.UserChapterBO;
import org.fm.util.RedisCache;

import java.util.List;
import java.util.Map;

/**
 * 用户购买课程表(UserChapter)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-11-13 15:08:47
 */
@Mapper
@CacheNamespace(implementation = RedisCache.class, eviction = RedisCache.class)
public interface UserChapterDao extends BaseMapper<UserChapterBO> {

    IPage<UserChapterBO> findPageForMap(IPage<UserChapterBO> page, @Param("map") Map<String, Object> filter);

    List<UserChapterBO> findListForMap(@Param("map") Map<String, Object> filter);

}