package org.fm.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * MetaObjectHandler
 * 自动填充工具类
 *
 * @author zou
 * @date 2020/10/28
 **/
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyMetaObjectHandler.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        //是否存在set方法
        boolean bol = metaObject.hasSetter("createTime");
        //拿到createdTime的值
        Object createdTime = getFieldValByName("createTime", metaObject);
        if (bol) {//有set方法
            if (createdTime == null) {//值为null填充
                setFieldValByName("createTime", new Date(), metaObject);
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //是否存在set方法
        boolean bol = metaObject.hasSetter("updateTime");
        //如果updateTime有定义值就不用mp的
        Object updateTime = getFieldValByName("updateTime", metaObject);
        if (bol) {//有set方法
            if (updateTime == null) {//值为null填充
                setFieldValByName("updateTime", new Date(), metaObject);
            }
        }
    }
}