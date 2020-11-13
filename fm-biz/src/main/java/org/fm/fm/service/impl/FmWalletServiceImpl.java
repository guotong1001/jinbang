package org.fm.fm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fm.constants.CodeEnum;
import org.fm.constants.PageResult;
import org.fm.fm.bo.FmWalletBO;
import org.fm.fm.dao.FmWalletDao;
import org.fm.fm.service.FmWalletService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 用户钱包表(FmWallet)表服务实现类
 *
 * @author Guoqing
 * @since 2020-11-13 15:07:19
 */
@Service("fmWalletService")
@Transactional
public class FmWalletServiceImpl extends ServiceImpl<FmWalletDao, FmWalletBO> implements FmWalletService {

    /**
     * 数据访问对象
     */
    @Resource
    private FmWalletDao fmWalletDao;

    @Override
    public PageResult<FmWalletBO> findPageForMap(IPage<FmWalletBO> page, Map<String, Object> filter) {
        IPage<FmWalletBO> iPage = fmWalletDao.findPageForMap(page, filter);
        return PageResult.<FmWalletBO>builder().data(iPage.getRecords())
                .count(iPage.getTotal()).code(CodeEnum.SUCCESS.getCode()).build();
    }

    @Override
    public List<FmWalletBO> findListForMap(Map<String, Object> filter) {
        List<FmWalletBO> result = fmWalletDao.findListForMap(filter);
        return result;
    }
}