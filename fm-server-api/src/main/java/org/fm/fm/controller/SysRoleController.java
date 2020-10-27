package org.fm.fm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.fm.bean.ResponseBean;
import org.fm.constants.BaseController;
import org.fm.constants.PageResult;
import org.fm.fm.bo.SysRoleBO;
import org.fm.fm.bo.SysRolePermissionRelationBO;
import org.fm.fm.service.SysRolePermissionRelationService;
import org.fm.fm.service.SysRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 系统角色表 (SysRole)表控制层
 *
 * @author Guoqing
 * @since 2020-09-18 11:02:09
 */
@RestController
@RequestMapping("/sysRole")
public class SysRoleController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleService sysRoleService;

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
        IPage<SysRoleBO> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        Map<String, Object> filter = buildFilter(request);
        filter.put("isDelete", null);
        PageResult<SysRoleBO> rsPage = sysRoleService.findPageForMap(page, filter);
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
        List<SysRoleBO> rs = sysRoleService.findListForMap(filter);
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
        return success(this.sysRoleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysRoleBO 实体对象
     * @return 新增结果
     */
    @PostMapping("/insert")
    public ResponseBean insert(@RequestBody SysRoleBO sysRoleBO) {
        return success(this.sysRoleService.save(sysRoleBO));
    }

    /**
     * 修改数据
     *
     * @param sysRoleBO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    public ResponseBean update(@RequestBody SysRoleBO sysRoleBO) {
        boolean delete = sysRolePermissionRelationService.remove(new QueryWrapper<SysRolePermissionRelationBO>()
                .eq("role_id", sysRoleBO.getId()));
        List<SysRolePermissionRelationBO> list = new ArrayList<SysRolePermissionRelationBO>();
        for (Integer permissionId : sysRoleBO.getPermissionIds()) {
            SysRolePermissionRelationBO rolePermissionRelationBO = new SysRolePermissionRelationBO();
            rolePermissionRelationBO.setRoleId(sysRoleBO.getId());
            rolePermissionRelationBO.setPermissionId(permissionId);
            list.add(rolePermissionRelationBO);
        }
        sysRolePermissionRelationService.saveBatch(list);
        return success(this.sysRoleService.updateById(sysRoleBO));
    }

    /**
     * 删除数据
     *
     * @param id 主键结合
     * @return 删除结果
     */
    @DeleteMapping("/deleteOne")
    public ResponseBean deleteOne(Long id) {
        sysRolePermissionRelationService.remove(new QueryWrapper<SysRolePermissionRelationBO>()
                .eq("role_id", id));
        return success(this.sysRoleService.removeById(id));
    }

    /**
     * 删除多条数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("/deleteList")
    public ResponseBean deleteList(@RequestParam("idList") String idList) {
        String[] ids = idList.split(",");
        sysRolePermissionRelationService.remove(new QueryWrapper<SysRolePermissionRelationBO>()
                .in("role_id",ids));
        return success(this.sysRoleService.removeByIds(Arrays.asList(ids)));
    }
}