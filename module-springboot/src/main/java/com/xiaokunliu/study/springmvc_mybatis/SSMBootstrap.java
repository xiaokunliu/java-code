package com.xiaokunliu.study.springmvc_mybatis;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * project:java-code
 * file:SSMBootstrap
 * package:com.xiaokunliu.springmvc_mybatis
 * date:2019/4/3 11:29 PM
 * author:keithl
 */
@SpringBootApplication
//@ComponentScan(basePackages = {"com.xiaokunliu.study.springmvc_mybatis"})
public class SSMBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder().bannerMode(Banner.Mode.OFF).run(args);
    }
}
