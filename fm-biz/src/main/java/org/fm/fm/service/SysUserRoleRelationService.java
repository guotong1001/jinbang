package org.fm.fm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.fm.constants.PageResult;
import org.fm.fm.bo.SysUserRoleRelationBO;

import java.util.List;
import java.util.Map;

/**
 * 系统用户-角色关系表 (SysUserRoleRelation)表服务接口
 *
 * @author Guoqing
 * @since 2020-09-18 11:04:04
 */
public interface SysUserRoleRelationService extends IService<SysUserRoleRelationBO> {

    /**
     * 分页查询 返回PageResult
     *
     * @param page
     * @param filter
     * @return
     */
    PageResult<SysUserRoleRelationBO> findPageForMap(IPage<SysUserRoleRelationBO> page, Map<String, Object> filter);


    /**
     * List查询
     *
     * @param filter
     * @return
     */
    List<SysUserRoleRelationBO> findListForMap(Map<String, Object> filter);


}
