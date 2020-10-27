package org.fm.fm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.fm.fm.bo.SysUserInfoBO;
import org.fm.util.RedisCache;

import java.util.List;
import java.util.Map;

/**
 * 系统用户信息表 (SysUserInfo)表数据库访问层
 *
 * @author Mr.zhang
 * @since 2020-09-16 11:08:28
 */
@Mapper
@CacheNamespace(implementation= RedisCache.class,eviction= RedisCache.class)
public interface SysUserInfoDao extends BaseMapper<SysUserInfoBO> {

    SysUserInfoBO findByUsername(String username);

    IPage<SysUserInfoBO> findPageForMap(IPage<SysUserInfoBO> page, @Param("map") Map<String, Object> filter);

    List<SysUserInfoBO> findListForMap(@Param("map") Map<String, Object> map);

//    @Select("select * from sys_user_info where is_delete = 0 and user_name = #{userName}")
}
