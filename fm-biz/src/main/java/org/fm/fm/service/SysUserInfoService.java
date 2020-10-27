package org.fm.fm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.fm.constants.PageResult;
import org.fm.fm.bo.SysUserInfoBO;

import java.util.List;
import java.util.Map;

/**
 * 系统用户信息表 (SysUserInfo)表服务接口
 *
 * @author Mr.zhang
 * @since 2020-09-16 11:16:02
 */
public interface SysUserInfoService extends IService<SysUserInfoBO> {

    SysUserInfoBO findByUsername(String Username);

    /**
     * 分页查询 返回PageResult
     * @param page
     * @param filter
     * @return
     */
    PageResult<SysUserInfoBO> findPageForMap(IPage<SysUserInfoBO> page, Map<String, Object> filter) ;


    /**
     * List查询
     * @param filter
     * @return
     */
    List<SysUserInfoBO> findListForMap(Map<String, Object> filter) ;
}
