package org.fm.fm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.fm.fm.bo.SysPermissionTypeBO;

import java.util.List;
import java.util.Map;

/**
 * 系统权限类型表 (SysPermissionType)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-09-18 11:01:48
 */
@Mapper
public interface SysPermissionTypeDao extends BaseMapper<SysPermissionTypeBO> {

    IPage<SysPermissionTypeBO> findPageForMap(IPage<SysPermissionTypeBO> page, @Param("map") Map<String, Object> filter);

    List<SysPermissionTypeBO> findListForMap(@Param("map") Map<String, Object> filter);

}