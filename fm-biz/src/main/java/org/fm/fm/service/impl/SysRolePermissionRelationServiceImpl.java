package org.fm.fm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fm.constants.CodeEnum;
import org.fm.constants.PageResult;
import org.fm.fm.bo.SysRolePermissionRelationBO;
import org.fm.fm.dao.SysRolePermissionRelationDao;
import org.fm.fm.service.SysRolePermissionRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 系统角色-权限关系表 (SysRolePermissionRelation)表服务实现类
 *
 * @author Guoqing
 * @since 2020-09-18 11:03:01
 */
@Service("sysRolePermissionRelationService")
public class SysRolePermissionRelationServiceImpl extends ServiceImpl<SysRolePermissionRelationDao, SysRolePermissionRelationBO> implements SysRolePermissionRelationService {

    /**
     * 数据访问对象
     */
    @Resource
    private SysRolePermissionRelationDao sysRolePermissionRelationDao;

    @Override
    public PageResult<SysRolePermissionRelationBO> findPageForMap(IPage<SysRolePermissionRelationBO> page, Map<String, Object> filter) {
        IPage<SysRolePermissionRelationBO> iPage = sysRolePermissionRelationDao.findPageForMap(page, filter);
        return PageResult.<SysRolePermissionRelationBO>builder().data(iPage.getRecords())
                .count(iPage.getTotal()).code(CodeEnum.SUCCESS.getCode()).build();
    }

    @Override
    public List<SysRolePermissionRelationBO> findListForMap(Map<String, Object> filter) {
        List<SysRolePermissionRelationBO> result = sysRolePermissionRelationDao.findListForMap(filter);
        return result;
    }
}