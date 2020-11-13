package org.fm.fm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fm.constants.CodeEnum;
import org.fm.constants.PageResult;
import org.fm.fm.bo.UserWrongTopicBO;
import org.fm.fm.dao.UserWrongTopicDao;
import org.fm.fm.service.UserWrongTopicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 用户错题关系表(UserWrongTopic)表服务实现类
 *
 * @author Guoqing
 * @since 2020-11-13 15:09:48
 */
@Service("userWrongTopicService")
@Transactional
public class UserWrongTopicServiceImpl extends ServiceImpl<UserWrongTopicDao, UserWrongTopicBO> implements UserWrongTopicService {

    /**
     * 数据访问对象
     */
    @Resource
    private UserWrongTopicDao userWrongTopicDao;

    @Override
    public PageResult<UserWrongTopicBO> findPageForMap(IPage<UserWrongTopicBO> page, Map<String, Object> filter) {
        IPage<UserWrongTopicBO> iPage = userWrongTopicDao.findPageForMap(page, filter);
        return PageResult.<UserWrongTopicBO>builder().data(iPage.getRecords())
                .count(iPage.getTotal()).code(CodeEnum.SUCCESS.getCode()).build();
    }

    @Override
    public List<UserWrongTopicBO> findListForMap(Map<String, Object> filter) {
        List<UserWrongTopicBO> result = userWrongTopicDao.findListForMap(filter);
        return result;
    }
}