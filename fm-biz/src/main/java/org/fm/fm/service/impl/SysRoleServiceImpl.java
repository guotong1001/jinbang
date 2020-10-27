package org.fm.fm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fm.constants.CodeEnum;
import org.fm.constants.PageResult;
import org.fm.fm.bo.SysRoleBO;
import org.fm.fm.bo.SysRolePermissionRelationBO;
import org.fm.fm.dao.SysRoleDao;
import org.fm.fm.dao.SysRolePermissionRelationDao;
import org.fm.fm.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 系统角色表 (SysRole)表服务实现类
 *
 * @author Guoqing
 * @since 2020-09-18 11:02:18
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleBO> implements SysRoleService {

    /**
     * 数据访问对象
     */
    @Resource
    private SysRoleDao sysRoleDao;

    @Resource
    private SysRolePermissionRelationDao sysRolePermissionRelationDao;

    @Override
    public PageResult<SysRoleBO> findPageForMap(IPage<SysRoleBO> page, Map<String, Object> filter) {
        IPage<SysRoleBO> iPage = sysRoleDao.findPageForMap(page, filter);
        List<SysRoleBO> result = iPage.getRecords();
        for (SysRoleBO bo : result) {
            List<SysRolePermissionRelationBO> byRoleId = sysRolePermissionRelationDao.findByRoleId(bo.getId());
            for (SysRolePermissionRelationBO relationBO : byRoleId) {
                bo.getPermissionIds().add(relationBO.getPermissionId());
            }
        }
        iPage.setRecords(result);
        return PageResult.<SysRoleBO>builder().data(iPage.getRecords())
                .count(iPage.getTotal()).code(CodeEnum.SUCCESS.getCode()).build();
    }

    @Override
    public List<SysRoleBO> findListForMap(Map<String, Object> filter) {
        List<SysRoleBO> result = sysRoleDao.findListForMap(filter);
        return result;
    }
}