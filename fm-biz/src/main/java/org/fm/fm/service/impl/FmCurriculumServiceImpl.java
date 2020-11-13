package org.fm.fm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fm.constants.CodeEnum;
import org.fm.constants.PageResult;
import org.fm.fm.bo.FmCurriculumBO;
import org.fm.fm.dao.FmCurriculumDao;
import org.fm.fm.service.FmCurriculumService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 课程分类表(FmCurriculum)表服务实现类
 *
 * @author Guoqing
 * @since 2020-11-13 14:49:56
 */
@Service("fmCurriculumService")
@Transactional
public class FmCurriculumServiceImpl extends ServiceImpl<FmCurriculumDao, FmCurriculumBO> implements FmCurriculumService {

    /**
     * 数据访问对象
     */
    @Resource
    private FmCurriculumDao fmCurriculumDao;

    @Override
    public PageResult<FmCurriculumBO> findPageForMap(IPage<FmCurriculumBO> page, Map<String, Object> filter) {
        IPage<FmCurriculumBO> iPage = fmCurriculumDao.findPageForMap(page, filter);
        return PageResult.<FmCurriculumBO>builder().data(iPage.getRecords())
                .count(iPage.getTotal()).code(CodeEnum.SUCCESS.getCode()).build();
    }

    @Override
    public List<FmCurriculumBO> findListForMap(Map<String, Object> filter) {
        List<FmCurriculumBO> result = fmCurriculumDao.findListForMap(filter);
        return result;
    }
}