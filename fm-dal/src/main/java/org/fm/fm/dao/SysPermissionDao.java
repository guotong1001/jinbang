package org.fm.fm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.fm.fm.bo.SysPermissionBO;

import java.util.List;
import java.util.Map;

/**
 * 系统权限表 (SysPermission)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-09-18 11:00:23
 */
@Mapper
public interface SysPermissionDao extends BaseMapper<SysPermissionBO> {

    IPage<SysPermissionBO> findPageForMap(IPage<SysPermissionBO> page, @Param("map") Map<String, Object> filter);

    List<SysPermissionBO> findListForMap(@Param("map") Map<String, Object> filter);

    SysPermissionBO findByPermissionCodeAndPermissionType(@Param("permissionCode") String permissionCode, @Param("permissionType")String permissionType);

}
