package org.fm.fm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fm.constants.CodeEnum;
import org.fm.constants.PageResult;
import org.fm.fm.bo.SysUserRoleRelationBO;
import org.fm.fm.dao.SysUserRoleRelationDao;
import org.fm.fm.service.SysUserRoleRelationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 系统用户-角色关系表 (SysUserRoleRelation)表服务实现类
 *
 * @author Guoqing
 * @since 2020-09-18 11:04:05
 */
@Service("sysUserRoleRelationService")
@Transactional
public class SysUserRoleRelationServiceImpl extends ServiceImpl<SysUserRoleRelationDao, SysUserRoleRelationBO> implements SysUserRoleRelationService {

    /**
     * 数据访问对象
     */
    @Resource
    private SysUserRoleRelationDao sysUserRoleRelationDao;

    @Override
    public PageResult<SysUserRoleRelationBO> findPageForMap(IPage<SysUserRoleRelationBO> page, Map<String, Object> filter) {
        IPage<SysUserRoleRelationBO> iPage = sysUserRoleRelationDao.findPageForMap(page, filter);
        return PageResult.<SysUserRoleRelationBO>builder().data(iPage.getRecords())
                .count(iPage.getTotal()).code(CodeEnum.SUCCESS.getCode()).build();
    }

    @Override
    public List<SysUserRoleRelationBO> findListForMap(Map<String, Object> filter) {
        List<SysUserRoleRelationBO> result = sysUserRoleRelationDao.findListForMap(filter);
        return result;
    }

}
