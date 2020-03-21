package com.xiaokunliu.interview.web.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * project:tpp_java
 * file:SwaggerConfig
 * package:com.tianpaopao.tpp.config
 * date:2019/7/18 5:11 PM
 * author:keithl
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xiaokunliu.*.api"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Web项目Restful API 接口文档说明")
                .description("采用POST/GET/DELETE/PUT对外提供接口文档的方式")
                .termsOfServiceUrl("参考方式：http://blog.didispace.com/springbootswagger2/")
                .contact("liuxiaokun")
                .version("1.0.0")
                .build();
    }
}
