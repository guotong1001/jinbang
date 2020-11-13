package org.fm.fm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.fm.fm.bo.FmRecordingBO;
import org.fm.util.RedisCache;

import java.util.List;
import java.util.Map;

/**
 * 录音表(FmRecording)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-11-13 14:56:04
 */
@Mapper
@CacheNamespace(implementation = RedisCache.class, eviction = RedisCache.class)
public interface FmRecordingDao extends BaseMapper<FmRecordingBO> {

    IPage<FmRecordingBO> findPageForMap(IPage<FmRecordingBO> page, @Param("map") Map<String, Object> filter);

    List<FmRecordingBO> findListForMap(@Param("map") Map<String, Object> filter);

}