package org.fm.fm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.fm.constants.PageResult;
import org.fm.fm.bo.SysUserProjectRelationBO;

import java.util.List;
import java.util.Map;

/**
 * 系统用户-项目关系表 (SysUserProjectRelation)表服务接口
 *
 * @author Guoqing
 * @since 2020-09-18 11:03:36
 */
public interface SysUserProjectRelationService extends IService<SysUserProjectRelationBO> {

    /**
     * 分页查询 返回PageResult
     *
     * @param page
     * @param filter
     * @return
     */
    PageResult<SysUserProjectRelationBO> findPageForMap(IPage<SysUserProjectRelationBO> page, Map<String, Object> filter);


    /**
     * List查询
     *
     * @param filter
     * @return
     */
    List<SysUserProjectRelationBO> findListForMap(Map<String, Object> filter);

}