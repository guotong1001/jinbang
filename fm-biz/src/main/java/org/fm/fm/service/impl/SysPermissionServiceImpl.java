package org.fm.fm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fm.constants.CodeEnum;
import org.fm.constants.PageResult;
import org.fm.fm.bo.SysPermissionBO;
import org.fm.fm.dao.SysPermissionDao;
import org.fm.fm.service.SysPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 系统权限表 (SysPermission)表服务实现类
 *
 * @author Guoqing
 * @since 2020-09-18 11:00:12
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionDao, SysPermissionBO> implements SysPermissionService {

    /**
     * 数据访问对象
     */
    @Resource
    private SysPermissionDao sysPermissionDao;

    @Override
    public PageResult<SysPermissionBO> findPageForMap(IPage<SysPermissionBO> page, Map<String, Object> filter) {
        IPage<SysPermissionBO> iPage = sysPermissionDao.findPageForMap(page, filter);
        return PageResult.<SysPermissionBO>builder().data(iPage.getRecords())
                .count(iPage.getTotal()).code(CodeEnum.SUCCESS.getCode()).build();
    }

    @Override
    public List<SysPermissionBO> findListForMap(Map<String, Object> filter) {
        List<SysPermissionBO> result = sysPermissionDao.findListForMap(filter);
        return result;
    }

    @Override
    public SysPermissionBO findByPermissionCodeAndPermissionType(String permissionCode, String permissionType) {
        return sysPermissionDao.findByPermissionCodeAndPermissionType(permissionCode, permissionType);
    }

}
