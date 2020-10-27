package org.fm.fm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fm.constants.CodeEnum;
import org.fm.constants.PageResult;
import org.fm.fm.bo.*;
import org.fm.fm.dao.*;
import org.fm.fm.service.SysUserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 系统用户信息表 (SysUserInfo)表服务实现类
 *
 * @author Mr.zhang
 * @since 2020-09-16 11:16:02
 */
@Service("sysUserInfoService")
public class SysUserInfoServiceImpl extends ServiceImpl<SysUserInfoDao, SysUserInfoBO> implements SysUserInfoService {

    @Resource
    private SysUserInfoDao sysUserInfoDao;
    @Resource
    private SysRoleDao sysRoleDao;
    @Resource
    private SysPermissionDao sysPermissionDao;
    @Resource
    private SysUserRoleRelationDao sysUserRoleRelationDao;
    @Resource
    private SysRolePermissionRelationDao sysRolePermissionRelationDao;

    /**
     * 通过用户名查询用户-角色-权限
     *
     * @param Username
     * @return
     */
    @Override
    public SysUserInfoBO findByUsername(String Username) {
        SysUserInfoBO sysUserInfoBO = sysUserInfoDao.findByUsername(Username);
        if (sysUserInfoBO != null) {
            Set<SysRoleBO> sysRoleBOS = new HashSet<>();
            //获取用户拥有角色ID
            List<SysUserRoleRelationBO> userRoleRelationBOS = sysUserRoleRelationDao.findByUserId(sysUserInfoBO.getId());
            for (SysUserRoleRelationBO userRoleRelationBO : userRoleRelationBOS) {
                SysRoleBO sysRoleBO = sysRoleDao.selectById(userRoleRelationBO.getRoleId());
                Set<SysPermissionBO> sysPermissionBOS = new HashSet<>();
                //角色拥有的权限ID
                List<SysRolePermissionRelationBO> releRolePermissionBOS = sysRolePermissionRelationDao.findByRoleId(userRoleRelationBO.getRoleId());
                for (SysRolePermissionRelationBO rolePermissionRelationBO : releRolePermissionBOS) {
                    sysPermissionBOS.add(sysPermissionDao.selectById(rolePermissionRelationBO.getPermissionId()));
                }
                sysRoleBO.setSysPermissionBOS(sysPermissionBOS);
                sysRoleBOS.add(sysRoleBO);
            }
            sysUserInfoBO.setSysRoleBOS(sysRoleBOS);
        }
        return sysUserInfoBO;
    }

    @Override
    public PageResult<SysUserInfoBO> findPageForMap(IPage<SysUserInfoBO> page, Map<String, Object> filter) {
        IPage<SysUserInfoBO> iPage = sysUserInfoDao.findPageForMap(page, filter);
        List<SysUserInfoBO> result = iPage.getRecords();
        for (SysUserInfoBO bo : result) {
            List<SysUserRoleRelationBO> byUserId = sysUserRoleRelationDao.findByUserId(bo.getId());
            for (SysUserRoleRelationBO relationBO : byUserId) {
                bo.getRoleIds().add(relationBO.getRoleId());
            }
        }
        iPage.setRecords(result);
        return PageResult.<SysUserInfoBO>builder().data(iPage.getRecords())
                .count(iPage.getTotal()).code(CodeEnum.SUCCESS.getCode()).build();
    }

    @Override
    public List<SysUserInfoBO> findListForMap(Map<String, Object> filter) {
        List<SysUserInfoBO> result = sysUserInfoDao.findListForMap(filter);
        return result;
    }

}
