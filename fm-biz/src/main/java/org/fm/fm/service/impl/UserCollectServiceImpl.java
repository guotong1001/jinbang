package org.fm.fm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fm.constants.CodeEnum;
import org.fm.constants.PageResult;
import org.fm.fm.bo.UserCollectBO;
import org.fm.fm.dao.UserCollectDao;
import org.fm.fm.service.UserCollectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 用户收藏关系表(UserCollect)表服务实现类
 *
 * @author Guoqing
 * @since 2020-11-13 15:09:23
 */
@Service("userCollectService")
@Transactional
public class UserCollectServiceImpl extends ServiceImpl<UserCollectDao, UserCollectBO> implements UserCollectService {

    /**
     * 数据访问对象
     */
    @Resource
    private UserCollectDao userCollectDao;

    @Override
    public PageResult<UserCollectBO> findPageForMap(IPage<UserCollectBO> page, Map<String, Object> filter) {
        IPage<UserCollectBO> iPage = userCollectDao.findPageForMap(page, filter);
        return PageResult.<UserCollectBO>builder().data(iPage.getRecords())
                .count(iPage.getTotal()).code(CodeEnum.SUCCESS.getCode()).build();
    }

    @Override
    public List<UserCollectBO> findListForMap(Map<String, Object> filter) {
        List<UserCollectBO> result = userCollectDao.findListForMap(filter);
        return result;
    }
}