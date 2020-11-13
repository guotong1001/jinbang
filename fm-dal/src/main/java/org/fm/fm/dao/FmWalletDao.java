package org.fm.fm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.fm.fm.bo.FmWalletBO;
import org.fm.util.RedisCache;

import java.util.List;
import java.util.Map;

/**
 * 用户钱包表(FmWallet)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-11-13 15:07:11
 */
@Mapper
@CacheNamespace(implementation = RedisCache.class, eviction = RedisCache.class)
public interface FmWalletDao extends BaseMapper<FmWalletBO> {

    IPage<FmWalletBO> findPageForMap(IPage<FmWalletBO> page, @Param("map") Map<String, Object> filter);

    List<FmWalletBO> findListForMap(@Param("map") Map<String, Object> filter);

}