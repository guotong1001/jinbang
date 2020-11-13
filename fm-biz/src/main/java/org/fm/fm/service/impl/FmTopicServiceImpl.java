package org.fm.fm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fm.constants.CodeEnum;
import org.fm.constants.PageResult;
import org.fm.fm.bo.FmTopicBO;
import org.fm.fm.dao.FmTopicDao;
import org.fm.fm.service.FmTopicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 题目表(FmTopic)表服务实现类
 *
 * @author Guoqing
 * @since 2020-11-13 14:59:49
 */
@Service("fmTopicService")
@Transactional
public class FmTopicServiceImpl extends ServiceImpl<FmTopicDao, FmTopicBO> implements FmTopicService {

    /**
     * 数据访问对象
     */
    @Resource
    private FmTopicDao fmTopicDao;

    @Override
    public PageResult<FmTopicBO> findPageForMap(IPage<FmTopicBO> page, Map<String, Object> filter) {
        IPage<FmTopicBO> iPage = fmTopicDao.findPageForMap(page, filter);
        return PageResult.<FmTopicBO>builder().data(iPage.getRecords())
                .count(iPage.getTotal()).code(CodeEnum.SUCCESS.getCode()).build();
    }

    @Override
    public List<FmTopicBO> findListForMap(Map<String, Object> filter) {
        List<FmTopicBO> result = fmTopicDao.findListForMap(filter);
        return result;
    }
}