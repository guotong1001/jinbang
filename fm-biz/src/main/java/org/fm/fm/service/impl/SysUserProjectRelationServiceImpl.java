package org.fm.fm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fm.constants.CodeEnum;
import org.fm.constants.PageResult;
import org.fm.fm.bo.SysUserProjectRelationBO;
import org.fm.fm.dao.SysUserProjectRelationDao;
import org.fm.fm.service.SysUserProjectRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 系统用户-项目关系表 (SysUserProjectRelation)表服务实现类
 *
 * @author Guoqing
 * @since 2020-09-18 11:03:36
 */
@Service("sysUserProjectRelationService")
public class SysUserProjectRelationServiceImpl extends ServiceImpl<SysUserProjectRelationDao, SysUserProjectRelationBO> implements SysUserProjectRelationService {

    /**
     * 数据访问对象
     */
    @Resource
    private SysUserProjectRelationDao sysUserProjectRelationDao;

    @Override
    public PageResult<SysUserProjectRelationBO> findPageForMap(IPage<SysUserProjectRelationBO> page, Map<String, Object> filter) {
        IPage<SysUserProjectRelationBO> iPage = sysUserProjectRelationDao.findPageForMap(page, filter);
        return PageResult.<SysUserProjectRelationBO>builder().data(iPage.getRecords())
                .count(iPage.getTotal()).code(CodeEnum.SUCCESS.getCode()).build();
    }

    @Override
    public List<SysUserProjectRelationBO> findListForMap(Map<String, Object> filter) {
        List<SysUserProjectRelationBO> result = sysUserProjectRelationDao.findListForMap(filter);
        return result;
    }
}