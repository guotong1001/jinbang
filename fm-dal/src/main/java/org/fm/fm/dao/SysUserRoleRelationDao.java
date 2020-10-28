package org.fm.fm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fm.fm.bo.SysUserRoleRelationBO;
import org.fm.util.RedisCache;

import java.util.List;
import java.util.Map;

/**
 * 系统用户-角色关系表 (SysUserRoleRelation)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-09-18 11:04:12
 */
@Mapper
@CacheNamespace(implementation= RedisCache.class,eviction= RedisCache.class)
public interface SysUserRoleRelationDao extends BaseMapper<SysUserRoleRelationBO> {

    IPage<SysUserRoleRelationBO> findPageForMap(IPage<SysUserRoleRelationBO> page, @Param("map") Map<String, Object> filter);

    List<SysUserRoleRelationBO> findListForMap(@Param("map") Map<String, Object> filter);

    @Select("select * from sys_user_role_relation where user_id = #{userId}")
    List<SysUserRoleRelationBO> findByUserId(Long userId);

}
