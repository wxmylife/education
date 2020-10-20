package com.panda.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class CodeGenerator {


  @Test
  public void run(){
    // 代码生成器
    AutoGenerator mpg = new AutoGenerator();
    // 全局配置
    GlobalConfig gc = new GlobalConfig();
    String projectPath = System.getProperty("user.dir");
    gc.setOutputDir("/Users/android/Documents/code/web/springboot/education/service/service-edu" + "/src/main/java");
    gc.setAuthor("abby");
    gc.setOpen(true);  //生成后是否打开资源管理器
    gc.setFileOverride(false);//是否重新覆盖
    gc.setServiceName("%sService");//去掉 Service 接口的首字母 I
    gc.setIdType(IdType.ASSIGN_ID);//主键策略
    gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
    gc.setSwagger2(true); //;实体属性 Swagger2 注解
    mpg.setGlobalConfig(gc);

    // 数据源配置
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setUrl("jdbc:mysql://localhost:3306/education?serverTimezone=GMT%2B8");
    // dsc.setSchemaName("public");
    dsc.setDriverName("com.mysql.cj.jdbc.Driver");
    dsc.setUsername("root");
    dsc.setPassword("Panda");
    dsc.setDbType(DbType.MYSQL);
    mpg.setDataSource(dsc);

    // 包配置
    PackageConfig pc = new PackageConfig();
    pc.setModuleName("eduservice");//模块名
    pc.setParent("com.wxmylife");
    pc.setController("controller");
    pc.setEntity("entity");
    pc.setService("service");
    pc.setMapper("mapper");
    mpg.setPackageInfo(pc);

    // 策略配置
    StrategyConfig strategyConfig=new StrategyConfig();
    strategyConfig.setInclude("edu_teacher");
    strategyConfig.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
    strategyConfig.setTablePrefix(pc.getModuleName()+"_");//生成实体类时去掉前缀
    strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
    strategyConfig.setEntityLombokModel(true);//lombok 模型
    strategyConfig.setRestControllerStyle(true);//restful api 风格
    strategyConfig.setControllerMappingHyphenStyle(true);//url中驼峰转连字符
    mpg.setStrategy(strategyConfig);

    mpg.execute();
  }
}
