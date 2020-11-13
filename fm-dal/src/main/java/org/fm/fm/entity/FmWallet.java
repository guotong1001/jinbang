package org.fm.fm.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户钱包表(FmWallet)表实体类
 *
 * @author Guoqing
 * @since 2020-11-13 15:07:12
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class FmWallet extends Model<FmWallet> {

    private static final long serialVersionUID = -58918004755209175L;


    private Long id;


    private Long userId;
    //余额    
    private Double balance;
    //创建时间    
    private Date createTime;
    //更新时间    
    private Date updateTime;
    //备注    
    private String remake;

    public FmWallet() {
    }


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}