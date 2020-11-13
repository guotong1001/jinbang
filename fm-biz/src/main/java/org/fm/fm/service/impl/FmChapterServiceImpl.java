package org.fm.fm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fm.constants.CodeEnum;
import org.fm.constants.PageResult;
import org.fm.fm.bo.FmChapterBO;
import org.fm.fm.dao.FmChapterDao;
import org.fm.fm.service.FmChapterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 课程章节表(FmChapter)表服务实现类
 *
 * @author Guoqing
 * @since 2020-11-13 14:49:28
 */
@Service("fmChapterService")
@Transactional
public class FmChapterServiceImpl extends ServiceImpl<FmChapterDao, FmChapterBO> implements FmChapterService {

    /**
     * 数据访问对象
     */
    @Resource
    private FmChapterDao fmChapterDao;

    @Override
    public PageResult<FmChapterBO> findPageForMap(IPage<FmChapterBO> page, Map<String, Object> filter) {
        IPage<FmChapterBO> iPage = fmChapterDao.findPageForMap(page, filter);
        return PageResult.<FmChapterBO>builder().data(iPage.getRecords())
                .count(iPage.getTotal()).code(CodeEnum.SUCCESS.getCode()).build();
    }

    @Override
    public List<FmChapterBO> findListForMap(Map<String, Object> filter) {
        List<FmChapterBO> result = fmChapterDao.findListForMap(filter);
        return result;
    }
}