package com.xiaokunliu.study.springboot_j2ee.spring.config.di;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by keithl on 2017/11/8.
 */

public class SpringApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DIConfig.class);
        FnController controller = applicationContext.getBean(FnController.class);
        controller.execute();
    }
}
