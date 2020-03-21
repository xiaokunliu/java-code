package com.xiaokunliu.interview.web;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * date:2019/11/22 20:34
 * author:keithl
 * desc: business desc etc.
 */
@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(WebApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .build()
                .run(args);
    }
}
