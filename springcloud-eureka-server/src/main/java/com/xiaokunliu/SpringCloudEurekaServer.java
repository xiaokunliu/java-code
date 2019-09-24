package com.xiaokunliu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class SpringCloudEurekaServer {
    public static void main( String[] args ) {
        // Eureka 分区（Region 地区 & Zone 机房）
        // 架构参考： https://juejin.im/post/5d68b73af265da03b12061be
//        https://segmentfault.com/a/1190000014107639#articleHeader2

        //System.out.println( "Hello World!" );
        // TODO 报错
        new SpringApplicationBuilder(SpringCloudEurekaServer.class).web(true).run(args);
    }
}
