package com.dtrees.study.springmvc_mybatis;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * project:java-code
 * file:SSMBootstrap
 * package:com.dtrees.springmvc_mybatis
 * date:2019/4/3 11:29 PM
 * author:keithl
 */
@SpringBootApplication
public class SSMBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder().bannerMode(Banner.Mode.OFF).run(args);
    }
}
