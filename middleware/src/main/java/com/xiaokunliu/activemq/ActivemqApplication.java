package com.xiaokunliu.activemq;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * project:album
 * file:AlbumApplication
 * package:com.xiaokunliu.album
 * date:2018/4/25 上午1:07
 * author:keithl
 */
@SpringBootApplication
public class ActivemqApplication {

    // devtools:https://blog.csdn.net/wjc475869/article/details/52442484
    public static void main(String[] args) {
//        SpringApplication.run(AlbumApplication.class, args);
        // 禁用图标
        new SpringApplicationBuilder(ActivemqApplication.class).bannerMode(Banner.Mode.OFF).run(args);

        /**
         * ActiveMQ默认采用61616端口提供JMS服务，使用8161端口提供管理控制台服务
         */
    }
}
