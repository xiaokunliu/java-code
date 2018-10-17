package com.dtrees.study.springboot.core;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by keithl on 2017/11/30.
 */
// 关闭特定的自动配置,自己指定参数exclude
@SpringBootApplication
public class HelloApplication {

    public static void main(String[] args) {
//        SpringApplication.run(HelloApplication.class,args);

        // 关闭banner 方式1
        SpringApplication application = new SpringApplication(HelloApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);

        // 方式2
//        new SpringApplicationBuilder().bannerMode(Banner.Mode.OFF).run(args);
    }

    /**
     * SpringBoot 运行原理
     *
     */
}
