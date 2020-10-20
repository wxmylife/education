package com.wxmylife.education.service.base.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import java.util.Date;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

@Component
public class MyMeteObjectHandle implements MetaObjectHandler {
  @Override public void insertFill(MetaObject metaObject) {
    strictInsertFill(metaObject,"gmtCreate", Date.class,new Date());
    strictInsertFill(metaObject,"gmtModified", Date.class,new Date());
  }

  @Override public void updateFill(MetaObject metaObject) {
    strictUpdateFill(metaObject,"gmtModified", Date.class,new Date());
  }
}
