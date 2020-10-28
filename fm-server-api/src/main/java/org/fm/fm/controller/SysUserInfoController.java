package org.fm.fm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.fm.bean.ResponseBean;
import org.fm.constants.BaseController;
import org.fm.constants.PageResult;
import org.fm.fm.bo.SysUserInfoBO;
import org.fm.fm.bo.SysUserRoleRelationBO;
import org.fm.fm.service.SysUserInfoService;
import org.fm.fm.service.SysUserRoleRelationService;
import org.fm.fm.vo.SysUserInfoVO;
import org.fm.service.FMUserService;
import org.fm.type.IsDeleteType;
import org.fm.util.AssertUtils;
import org.fm.util.SysUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 系统用户信息表 (SysUserInfo)表控制层
 *
 * @author Mr.zhang
 * @since 2020-09-16 11:16:50
 */
@RestController
@RequestMapping("/sysUserInfo")
public class SysUserInfoController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserInfoService sysUserInfoService;

    @Autowired
    private FMUserService fmUserService;

    @Autowired
    private RedisTokenStore redisTokenStore;

    @Autowired
    private SysUserRoleRelationService sysUserRoleRelationService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping("/user")
    public ResponseBean findUser() {
        SysUserInfoBO sysUserInfoBO = SysUserUtil.getLoginAppUser().getSysUserInfoBO();
        sysUserInfoBO.setPassword("");
        return success(sysUserInfoBO);
    }

    /**
     * @param authorization
     * @return
     * @description 用户注销
     */
    @GetMapping("user/logout")
//    @PreAuthorize("@Permit.hasPermit('sys:user:login', '系统用户登录', '0')") //（0系统|1项目|2菜单|3功能）
    public ResponseBean logout(@RequestHeader("Authorization") String authorization) {
        redisTokenStore.removeAccessToken(AssertUtils.extracteToken(authorization));
        return ResponseBean.success();
    }

    /**
     * @param sysUserInfoVO
     * @return
     * @description 用户登录
     */
    @PostMapping("user/login")
    public ResponseBean login(SysUserInfoVO sysUserInfoVO) {
        return fmUserService.login(sysUserInfoVO);
    }

    /**
     * 分页查询所有数据
     *
     * @param current,size 分页数据
     * @param request      查询条件
     * @return 分页数据
     */
    @GetMapping("/selectPage/{current}/{size}")
    public ResponseBean selectPage(@PathVariable int current, @PathVariable int size, HttpServletRequest request) {
        IPage<SysUserInfoBO> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        Map<String, Object> filter = buildFilter(request);
        filter.put("isDelete", IsDeleteType.ISDELETE_TYPE.getKey());
        PageResult<SysUserInfoBO> rsPage = sysUserInfoService.findPageForMap(page, filter);

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
        filter.put("isDelete", IsDeleteType.ISDELETE_TYPE.getKey());
        List<SysUserInfoBO> rs = sysUserInfoService.findListForMap(filter);

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
        return success(this.sysUserInfoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysUserInfoBO 实体对象
     * @return 新增结果
     */
    @PostMapping("/insert")
    public ResponseBean insert(@RequestBody SysUserInfoBO sysUserInfoBO) {
        sysUserInfoBO.setPassword(passwordEncoder.encode(sysUserInfoBO.getPassword()));
        return success(this.sysUserInfoService.save(sysUserInfoBO));
    }

    /**
     * 修改数据
     *
     * @param sysUserInfoBO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    public ResponseBean update(@RequestBody SysUserInfoBO sysUserInfoBO) {
        boolean delete = sysUserRoleRelationService.remove(new QueryWrapper<SysUserRoleRelationBO>()
                .eq("user_id", sysUserInfoBO.getId()));
        List<SysUserRoleRelationBO> list = new ArrayList<SysUserRoleRelationBO>();
        for (Long roleId : sysUserInfoBO.getRoleIds()) {
            SysUserRoleRelationBO userRoleRelationBO = new SysUserRoleRelationBO();
            userRoleRelationBO.setUserId(sysUserInfoBO.getId());
            userRoleRelationBO.setRoleId(roleId);
            list.add(userRoleRelationBO);
        }
        sysUserRoleRelationService.saveBatch(list);
        return success(this.sysUserInfoService.updateById(sysUserInfoBO));
    }

    /**
     * 修改状态
     *
     * @param sysUserInfoBO 实体对象
     * @return 修改结果
     */
    @PutMapping("/updateEnabled")
    public ResponseBean updateEnabled(@RequestBody SysUserInfoBO sysUserInfoBO) {
        return success(this.sysUserInfoService.updateById(sysUserInfoBO));
    }

    /**
     * 删除数据
     *
     * @param id 主键结合
     * @return 删除结果
     */
    @DeleteMapping("deleteOne")
    public ResponseBean deleteOne(@RequestParam("id") Long id) {
        sysUserRoleRelationService.remove(new QueryWrapper<SysUserRoleRelationBO>()
                .eq("user_id", id));
        return success(this.sysUserInfoService.removeById(id));
    }

    /**
     * 删除多条数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("deleteList")
    public ResponseBean deleteList(@RequestParam("idList") String idList) {
        String[] ids = idList.split(",");
        sysUserRoleRelationService.remove(new QueryWrapper<SysUserRoleRelationBO>()
                .in("user_id", ids));
        return success(this.sysUserInfoService.removeByIds(Arrays.asList(ids)));
    }
}
