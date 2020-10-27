package org.fm.fm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.fm.fm.bo.SysUserProjectRelationBO;

import java.util.List;
import java.util.Map;

/**
 * 系统用户-项目关系表 (SysUserProjectRelation)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-09-18 11:03:43
 */
@Mapper
public interface SysUserProjectRelationDao extends BaseMapper<SysUserProjectRelationBO> {

    IPage<SysUserProjectRelationBO> findPageForMap(IPage<SysUserProjectRelationBO> page, @Param("map") Map<String, Object> filter);

    List<SysUserProjectRelationBO> findListForMap(@Param("map") Map<String, Object> filter);

}