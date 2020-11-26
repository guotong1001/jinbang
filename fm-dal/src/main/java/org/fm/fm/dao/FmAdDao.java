package org.fm.fm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.fm.fm.bo.FmAdBO;
import org.fm.util.RedisCache;

import java.util.List;
import java.util.Map;

/**
 * 广告表(FmAd)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-11-26 11:36:52
 */
@Mapper
@CacheNamespace(implementation = RedisCache.class, eviction = RedisCache.class)
public interface FmAdDao extends BaseMapper<FmAdBO> {

    IPage<FmAdBO> findPageForMap(IPage<FmAdBO> page, @Param("map") Map<String, Object> filter);

    List<FmAdBO> findListForMap(@Param("map") Map<String, Object> filter);

}