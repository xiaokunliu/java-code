package com.xiaokunliu.study.springboot_j2ee.spring.config.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by keithl on 2017/11/8.
 */

public class SpringApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
//
//        // 通过配置注解来拦截
        AopAnnotationService aopAnnotationService = applicationContext.getBean(AopAnnotationService.class);
        aopAnnotationService.add();
//
//
//        // 通过使用方法来拦截
       AopService aopService = applicationContext.getBean(AopService.class);
        aopService.add();
    }
}
