package org.fm.fm.bo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.fm.fm.entity.FmWallet;

/**
 * 用户钱包表(FmWallet)表数据库访问层
 *
 * @author Guoqing
 * @since 2020-11-13 15:07:12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("fm_wallet")
public class FmWalletBO extends FmWallet {

}