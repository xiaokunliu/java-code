package com.dtrees.study.spring.core.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by keithl on 2017/11/8.
 */

public class ELApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ELConfig.class);
        ELConfig elConfig = applicationContext.getBean(ELConfig.class);
        elConfig.output();
        applicationContext.close();
    }
}
