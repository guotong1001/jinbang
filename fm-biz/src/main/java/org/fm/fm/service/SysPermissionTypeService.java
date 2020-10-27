package org.fm.fm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.fm.constants.PageResult;
import org.fm.fm.bo.SysPermissionTypeBO;

import java.util.List;
import java.util.Map;

/**
 * 系统权限类型表 (SysPermissionType)表服务接口
 *
 * @author Guoqing
 * @since 2020-09-18 11:01:38
 */
public interface SysPermissionTypeService extends IService<SysPermissionTypeBO> {

    /**
     * 分页查询 返回PageResult
     *
     * @param page
     * @param filter
     * @return
     */
    PageResult<SysPermissionTypeBO> findPageForMap(IPage<SysPermissionTypeBO> page, Map<String, Object> filter);


    /**
     * List查询
     *
     * @param filter
     * @return
     */
    List<SysPermissionTypeBO> findListForMap(Map<String, Object> filter);

}