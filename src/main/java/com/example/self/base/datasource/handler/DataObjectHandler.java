package com.example.self.base.datasource.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * @descriptions: DataObjectHandler
 * @author: qiuming
 * @date: 2025/1/18 12:58
 * @version: 1.0
 */
public class DataObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByNameIfNull("createTime", new Date(), metaObject);
        this.setFieldValByNameIfNull("updateTime", new Date(), metaObject);
        this.setFieldValByName("deleteFlag", 0, metaObject);
        this.setFieldValByName("lockVersion", 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }


    private void setFieldValByNameIfNull(String fieldName, Object fieldVal, MetaObject metaObject) {
        if (metaObject.getValue(fieldName) == null) {
            this.setFieldValByName(fieldName, fieldVal, metaObject);
        }
    }
}
