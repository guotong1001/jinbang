package org.fm.fm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.fm.bean.ResponseBean;
import org.fm.constants.BaseController;
import org.fm.constants.PageResult;
import org.fm.fm.bo.SysUserProjectRelationBO;
import org.fm.fm.service.SysUserProjectRelationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 系统用户-项目关系表 (SysUserProjectRelation)表控制层
 *
 * @author Guoqing
 * @since 2020-09-18 11:03:26
 */
@RestController
@RequestMapping("sysUserProjectRelation")
public class SysUserProjectRelationController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserProjectRelationService sysUserProjectRelationService;

    /**
     * 分页查询所有数据
     *
     * @param current,size 分页对象
     * @param request      查询条件
     * @return 分页数据
     */
    @GetMapping("/selectPage/{current}/{size}")
    public ResponseBean selectPage(@PathVariable int current, @PathVariable int size, HttpServletRequest request) {
        IPage<SysUserProjectRelationBO> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        Map<String, Object> filter = buildFilter(request);
        PageResult<SysUserProjectRelationBO> rsPage = sysUserProjectRelationService.findPageForMap(page, filter);
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
        List<SysUserProjectRelationBO> rs = sysUserProjectRelationService.findListForMap(filter);
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
        return success(this.sysUserProjectRelationService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysUserProjectRelationBO 实体对象
     * @return 新增结果
     */
    @PostMapping("/insert")
    public ResponseBean insert(@RequestBody SysUserProjectRelationBO sysUserProjectRelationBO) {
        return success(this.sysUserProjectRelationService.save(sysUserProjectRelationBO));
    }

    /**
     * 修改数据
     *
     * @param sysUserProjectRelationBO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    public ResponseBean update(@RequestBody SysUserProjectRelationBO sysUserProjectRelationBO) {
        return success(this.sysUserProjectRelationService.updateById(sysUserProjectRelationBO));
    }

    /**
     * 删除数据
     *
     * @param id 主键结合
     * @return 删除结果
     */
    @DeleteMapping("/deleteOne")
    public ResponseBean deleteOne(Long id) {
        return success(this.sysUserProjectRelationService.removeById(id));
    }

    /**
     * 删除多条数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("/deleteList")
    public ResponseBean deleteList(@RequestParam("idList") List<Long> idList) {
        return success(this.sysUserProjectRelationService.removeByIds(idList));
    }
}