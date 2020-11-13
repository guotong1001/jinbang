package org.fm.fm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.fm.constants.PageResult;
import org.fm.fm.bo.FmWalletBO;

import java.util.List;
import java.util.Map;

/**
 * 用户钱包表(FmWallet)表服务接口
 *
 * @author Guoqing
 * @since 2020-11-13 15:07:19
 */
public interface FmWalletService extends IService<FmWalletBO> {

    /**
     * 分页查询 返回PageResult
     *
     * @param page
     * @param filter
     * @return
     */
    PageResult<FmWalletBO> findPageForMap(IPage<FmWalletBO> page, Map<String, Object> filter);


    /**
     * List查询
     *
     * @param filter
     * @return
     */
    List<FmWalletBO> findListForMap(Map<String, Object> filter);

}