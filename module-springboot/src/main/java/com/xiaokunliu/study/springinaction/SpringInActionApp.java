package com.xiaokunliu.study.springinaction;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * project:java-code
 * file:SpringInActionApp
 * package:com.xiaokunliu.study.springinaction
 * date:2019/9/22 17:35
 * author:keithl
 */
@SpringBootApplication
public class SpringInActionApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringInActionApp.class).bannerMode(Banner.Mode.OFF).run(args);
    }
}
