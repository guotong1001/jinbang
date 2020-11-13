package org.fm.fm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fm.constants.CodeEnum;
import org.fm.constants.PageResult;
import org.fm.fm.bo.FmAloneBO;
import org.fm.fm.dao.FmAloneDao;
import org.fm.fm.service.FmAloneService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 单独视频音频表（与主分类内容不互通）(FmAlone)表服务实现类
 *
 * @author Guoqing
 * @since 2020-11-13 14:47:15
 */
@Service("fmAloneService")
@Transactional
public class FmAloneServiceImpl extends ServiceImpl<FmAloneDao, FmAloneBO> implements FmAloneService {

    /**
     * 数据访问对象
     */
    @Resource
    private FmAloneDao fmAloneDao;

    @Override
    public PageResult<FmAloneBO> findPageForMap(IPage<FmAloneBO> page, Map<String, Object> filter) {
        IPage<FmAloneBO> iPage = fmAloneDao.findPageForMap(page, filter);
        return PageResult.<FmAloneBO>builder().data(iPage.getRecords())
                .count(iPage.getTotal()).code(CodeEnum.SUCCESS.getCode()).build();
    }

    @Override
    public List<FmAloneBO> findListForMap(Map<String, Object> filter) {
        List<FmAloneBO> result = fmAloneDao.findListForMap(filter);
        return result;
    }
}