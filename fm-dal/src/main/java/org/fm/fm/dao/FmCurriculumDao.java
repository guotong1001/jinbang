package org.fm.fm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.fm.fm.bo.FmCurriculumBO;
import org.fm.util.RedisCache;

import java.util.List;
import java.util.Map;

/**
 * 课程分类表(FmCurriculum)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-11-13 14:49:49
 */
@Mapper
@CacheNamespace(implementation = RedisCache.class, eviction = RedisCache.class)
public interface FmCurriculumDao extends BaseMapper<FmCurriculumBO> {

    IPage<FmCurriculumBO> findPageForMap(IPage<FmCurriculumBO> page, @Param("map") Map<String, Object> filter);

    List<FmCurriculumBO> findListForMap(@Param("map") Map<String, Object> filter);

}