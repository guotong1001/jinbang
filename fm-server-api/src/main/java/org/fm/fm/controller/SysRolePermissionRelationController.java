package org.fm.fm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.fm.bean.ResponseBean;
import org.fm.constants.BaseController;
import org.fm.constants.PageResult;
import org.fm.fm.bo.SysRolePermissionRelationBO;
import org.fm.fm.service.SysRolePermissionRelationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 系统角色-权限关系表 (SysRolePermissionRelation)表控制层
 *
 * @author Guoqing
 * @since 2020-09-18 11:02:45
 */
@RestController
@RequestMapping("sysRolePermissionRelation")
public class SysRolePermissionRelationController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private SysRolePermissionRelationService sysRolePermissionRelationService;

    /**
     * 分页查询所有数据
     *
     * @param current,size 分页对象
     * @param request      查询条件
     * @return 分页数据
     */
    @GetMapping("/selectPage/{current}/{size}")
    public ResponseBean selectPage(@PathVariable int current, @PathVariable int size, HttpServletRequest request) {
        IPage<SysRolePermissionRelationBO> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        Map<String, Object> filter = buildFilter(request);
        PageResult<SysRolePermissionRelationBO> rsPage = sysRolePermissionRelationService.findPageForMap(page, filter);
        return success(rsPage);
    }

    /**
     * 查询所有数据
     *
     * @param request 查询条件
     * @return 所有数据
     */
    @GetMapping("/selectAll")
    public ResponseBean selectAll(HttpServletRequest request) {
        Map<String, Object> filter = buildFilter(request);
        List<SysRolePermissionRelationBO> rs = sysRolePermissionRelationService.findListForMap(filter);
        return success(rs);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne/{id}")
    public ResponseBean selectOne(@PathVariable Serializable id) {
        return success(this.sysRolePermissionRelationService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysRolePermissionRelationBO 实体对象
     * @return 新增结果
     */
    @PostMapping("/insert")
    public ResponseBean insert(@RequestBody SysRolePermissionRelationBO sysRolePermissionRelationBO) {
        return success(this.sysRolePermissionRelationService.save(sysRolePermissionRelationBO));
    }

    /**
     * 修改数据
     *
     * @param sysRolePermissionRelationBO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    public ResponseBean update(@RequestBody SysRolePermissionRelationBO sysRolePermissionRelationBO) {
        return success(this.sysRolePermissionRelationService.updateById(sysRolePermissionRelationBO));
    }

    /**
     * 删除数据
     *
     * @param id 主键结合
     * @return 删除结果
     */
    @DeleteMapping("/deleteOne")
    public ResponseBean deleteOne(Long id) {
        return success(this.sysRolePermissionRelationService.removeById(id));
    }

    /**
     * 删除多条数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("/deleteList")
    public ResponseBean deleteList(@RequestParam("idList") List<Long> idList) {
        return success(this.sysRolePermissionRelationService.removeByIds(idList));
    }
}