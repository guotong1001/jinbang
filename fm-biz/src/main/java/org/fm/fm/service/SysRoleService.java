package org.fm.fm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.fm.constants.PageResult;
import org.fm.fm.bo.SysRoleBO;

import java.util.List;
import java.util.Map;

/**
 * 系统角色表 (SysRole)表服务接口
 *
 * @author Guoqing
 * @since 2020-09-18 11:02:18
 */
public interface SysRoleService extends IService<SysRoleBO> {

    /**
     * 分页查询 返回PageResult
     *
     * @param page
     * @param filter
     * @return
     */
    PageResult<SysRoleBO> findPageForMap(IPage<SysRoleBO> page, Map<String, Object> filter);


    /**
     * List查询
     *
     * @param filter
     * @return
     */
    List<SysRoleBO> findListForMap(Map<String, Object> filter);

}