package org.fm.fm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fm.constants.CodeEnum;
import org.fm.constants.PageResult;
import org.fm.fm.bo.FmAdBO;
import org.fm.fm.dao.FmAdDao;
import org.fm.fm.service.FmAdService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 广告表(FmAd)表服务实现类
 *
 * @author Guoqing
 * @since 2020-11-26 11:37:04
 */
@Service("fmAdService")
@Transactional
public class FmAdServiceImpl extends ServiceImpl<FmAdDao, FmAdBO> implements FmAdService {

    /**
     * 数据访问对象
     */
    @Resource
    private FmAdDao fmAdDao;

    @Override
    public PageResult<FmAdBO> findPageForMap(IPage<FmAdBO> page, Map<String, Object> filter) {
        IPage<FmAdBO> iPage = fmAdDao.findPageForMap(page, filter);
        return PageResult.<FmAdBO>builder().data(iPage.getRecords())
                .count(iPage.getTotal()).code(CodeEnum.SUCCESS.getCode()).build();
    }

    @Override
    public List<FmAdBO> findListForMap(Map<String, Object> filter) {
        List<FmAdBO> result = fmAdDao.findListForMap(filter);
        return result;
    }
}