package org.fm.fm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fm.constants.CodeEnum;
import org.fm.constants.PageResult;
import org.fm.fm.bo.SysPermissionTypeBO;
import org.fm.fm.dao.SysPermissionTypeDao;
import org.fm.fm.service.SysPermissionTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 系统权限类型表 (SysPermissionType)表服务实现类
 *
 * @author Guoqing
 * @since 2020-09-18 11:01:39
 */
@Service("sysPermissionTypeService")
public class SysPermissionTypeServiceImpl extends ServiceImpl<SysPermissionTypeDao, SysPermissionTypeBO> implements SysPermissionTypeService {

    /**
     * 数据访问对象
     */
    @Resource
    private SysPermissionTypeDao sysPermissionTypeDao;

    @Override
    public PageResult<SysPermissionTypeBO> findPageForMap(IPage<SysPermissionTypeBO> page, Map<String, Object> filter) {
        IPage<SysPermissionTypeBO> iPage = sysPermissionTypeDao.findPageForMap(page, filter);
        return PageResult.<SysPermissionTypeBO>builder().data(iPage.getRecords())
                .count(iPage.getTotal()).code(CodeEnum.SUCCESS.getCode()).build();
    }

    @Override
    public List<SysPermissionTypeBO> findListForMap(Map<String, Object> filter) {
        List<SysPermissionTypeBO> result = sysPermissionTypeDao.findListForMap(filter);
        return result;
    }
}