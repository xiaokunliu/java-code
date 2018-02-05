package com.dtrees.study.springboot.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by keithl on 2017/11/30.
 */
// 关闭特定的自动配置,自己指定
@SpringBootApplication
public class HelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class,args);
    }

    /**
     * SpringBoot 运行原理
     *  
     */
}
