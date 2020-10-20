package com.wxmylife.eduservice.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.wxmylife.eduservice.mapper")
public class EduConfig {


  @Bean
  public MybatisPlusInterceptor paginationInnerInterceptor(){
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    PaginationInnerInterceptor paginationInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
    paginationInterceptor.setMaxLimit(5L);
    interceptor.addInnerInterceptor(paginationInterceptor);
    return interceptor;
  }
}
