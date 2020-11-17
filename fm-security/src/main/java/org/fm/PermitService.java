package org.fm;

import org.apache.commons.lang3.StringUtils;
import org.fm.bean.FMUserInfo;
import org.fm.consts.SysConsts;
import org.fm.fm.bo.SysPermissionBO;
import org.fm.fm.bo.SysRolePermissionRelationBO;
import org.fm.fm.service.SysPermissionService;
import org.fm.fm.service.SysRolePermissionRelationService;
import org.fm.fm.service.SysUserInfoService;
import org.fm.fm.service.SysUserRoleRelationService;
import org.fm.util.SysUserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @项目名称：fm
 * @类名称：permissionService
 * @类描述：TODO 自定义权限验证
 * @作者：邹国庆 @创建时间：2020/4/5 22:38
 * @备注：
 * @version：
 * @Copyright (C)：
 */
@Component("Permit")
public class PermitService {

    @Autowired
    private SysUserInfoService sysUserInfoService;
    @Autowired
    private SysPermissionService sysPermissionService;
    @Autowired
    private SysUserRoleRelationService sysUserRoleRelationService;
    @Autowired
    private SysRolePermissionRelationService sysRolePermissionRelationService;

        private static final Logger logger = LoggerFactory.getLogger(PermitService.class);

        /**
         * 验证用户是否具备某权限
         * @param permissionCode 权限字符串
         * @param permissionInfo 权限说明
         * @param permissionType 权限类型
         * @return 用户是否具备某权限
         */
        public boolean hasPermit(String permissionCode, String permissionInfo, String permissionType){
            if (StringUtils.isEmpty(permissionCode)){
                return false;
            }
            SysPermissionBO sysPermissionBO = sysPermissionService.findByPermissionCodeAndPermissionType(permissionCode, permissionType);
            //权限编码是否存在
            if(sysPermissionBO != null){ //
                FMUserInfo fmUserInfo = SysUserUtil.getLoginAppUser();
                //判断登录用户是否包含 "permissionCode" 权限
                return fmUserInfo.getAuthorities().contains(new SimpleGrantedAuthority(SysConsts.ROLE_PREFIX+permissionCode));
            }
            try {
                //添加
                SysPermissionBO sysPermission = new SysPermissionBO(permissionCode, permissionType, permissionInfo, new Date());
                sysPermissionService.save(sysPermission);
                SysPermissionBO spb = sysPermissionService.findByPermissionCodeAndPermissionType(permissionCode, permissionType);
                sysRolePermissionRelationService.save(new SysRolePermissionRelationBO(SysConsts.SUPER_ADMIN.longValue(), spb.getId()));
                return true;
            }catch (Exception e){
                e.printStackTrace();
            }
            return true;
    }
}
