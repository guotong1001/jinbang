package org.fm.fm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fm.constants.CodeEnum;
import org.fm.constants.PageResult;
import org.fm.fm.bo.UserChapterBO;
import org.fm.fm.dao.UserChapterDao;
import org.fm.fm.service.UserChapterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 用户购买课程表(UserChapter)表服务实现类
 *
 * @author Guoqing
 * @since 2020-11-13 15:08:56
 */
@Service("userChapterService")
@Transactional
public class UserChapterServiceImpl extends ServiceImpl<UserChapterDao, UserChapterBO> implements UserChapterService {

    /**
     * 数据访问对象
     */
    @Resource
    private UserChapterDao userChapterDao;

    @Override
    public PageResult<UserChapterBO> findPageForMap(IPage<UserChapterBO> page, Map<String, Object> filter) {
        IPage<UserChapterBO> iPage = userChapterDao.findPageForMap(page, filter);
        return PageResult.<UserChapterBO>builder().data(iPage.getRecords())
                .count(iPage.getTotal()).code(CodeEnum.SUCCESS.getCode()).build();
    }

    @Override
    public List<UserChapterBO> findListForMap(Map<String, Object> filter) {
        List<UserChapterBO> result = userChapterDao.findListForMap(filter);
        return result;
    }
}