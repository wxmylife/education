package com.wxmylife.education.service.base;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket webApiConfig(){
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("webApi")
        .apiInfo(webApiInfo())
        .select()
        .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
        .paths(Predicates.not(PathSelectors.regex("/error.*")))
        .build();
  }

  private ApiInfo webApiInfo(){
    return new ApiInfoBuilder()
        .title("api文档")
        .description("微服务接口")
        .version("1.0")
        .contact(new Contact("wxmylife","http://www.abby.com","wxmylife@163.com"))
        .build();
  }
}
