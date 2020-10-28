package org.fm.fm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fm.fm.bo.SysRolePermissionRelationBO;
import org.fm.util.RedisCache;

import java.util.List;
import java.util.Map;

/**
 * 系统角色-权限关系表 (SysRolePermissionRelation)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-09-18 11:03:08
 */
@Mapper
@CacheNamespace(implementation= RedisCache.class,eviction= RedisCache.class)
public interface SysRolePermissionRelationDao extends BaseMapper<SysRolePermissionRelationBO> {

    IPage<SysRolePermissionRelationBO> findPageForMap(IPage<SysRolePermissionRelationBO> page, @Param("map") Map<String, Object> filter);

    List<SysRolePermissionRelationBO> findListForMap(@Param("map") Map<String, Object> filter);

    @Select("select * from sys_role_permission_relation where role_id = #{roleId}")
    List<SysRolePermissionRelationBO> findByRoleId(Long roleId);

}