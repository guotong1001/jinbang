package org.fm.fm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.fm.constants.PageResult;
import org.fm.fm.bo.SysPermissionBO;

import java.util.List;
import java.util.Map;

/**
 * 系统权限表 (SysPermission)表服务接口
 *
 * @author Guoqing
 * @since 2020-09-18 11:00:11
 */
public interface SysPermissionService extends IService<SysPermissionBO> {

    /**
     * 分页查询 返回PageResult
     *
     * @param page
     * @param filter
     * @return
     */
    PageResult<SysPermissionBO> findPageForMap(IPage<SysPermissionBO> page, Map<String, Object> filter);


    /**
     * List查询
     *
     * @param filter
     * @return
     */
    List<SysPermissionBO> findListForMap(Map<String, Object> filter);

    /**
     *
     * @param permissionCode
     * @param permissionType
     * @return
     */
    SysPermissionBO findByPermissionCodeAndPermissionType(String permissionCode, String permissionType);

}
