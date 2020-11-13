package org.fm.fm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.fm.fm.bo.FmAloneBO;
import org.fm.util.RedisCache;

import java.util.List;
import java.util.Map;

/**
 * 单独视频音频表（与主分类内容不互通）(FmAlone)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-11-13 14:46:52
 */
@Mapper
@CacheNamespace(implementation = RedisCache.class, eviction = RedisCache.class)
public interface FmAloneDao extends BaseMapper<FmAloneBO> {

    IPage<FmAloneBO> findPageForMap(IPage<FmAloneBO> page, @Param("map") Map<String, Object> filter);

    List<FmAloneBO> findListForMap(@Param("map") Map<String, Object> filter);

}