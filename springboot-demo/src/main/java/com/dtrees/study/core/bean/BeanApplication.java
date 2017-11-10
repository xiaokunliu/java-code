package com.dtrees.study.core.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by keithl on 2017/11/8.
 */

public class BeanApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(BeanConfig.class);

        BeanWayService beanWayService = context.getBean(BeanWayService.class);
        System.out.println(beanWayService);

        JSR250WayService jsr250WayService = context.getBean(JSR250WayService.class);
        System.out.println(jsr250WayService);

    }
}
