package org.fm.fm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.fm.constants.PageResult;
import org.fm.fm.bo.SysRolePermissionRelationBO;

import java.util.List;
import java.util.Map;

/**
 * 系统角色-权限关系表 (SysRolePermissionRelation)表服务接口
 *
 * @author Guoqing
 * @since 2020-09-18 11:03:00
 */
public interface SysRolePermissionRelationService extends IService<SysRolePermissionRelationBO> {

    /**
     * 分页查询 返回PageResult
     *
     * @param page
     * @param filter
     * @return
     */
    PageResult<SysRolePermissionRelationBO> findPageForMap(IPage<SysRolePermissionRelationBO> page, Map<String, Object> filter);


    /**
     * List查询
     *
     * @param filter
     * @return
     */
    List<SysRolePermissionRelationBO> findListForMap(Map<String, Object> filter);

}