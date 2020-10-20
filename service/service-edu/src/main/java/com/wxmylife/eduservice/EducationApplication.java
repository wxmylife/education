package com.wxmylife.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = {"com.wxmylife"})
// @EnableDiscoveryClient
// @EnableFeignClients
@EnableSwagger2
public class EducationApplication {

  public static void main(String[] args) {
    SpringApplication.run(EducationApplication.class);
  }
}
