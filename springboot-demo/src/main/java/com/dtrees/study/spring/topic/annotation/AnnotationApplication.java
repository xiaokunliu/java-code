package com.dtrees.study.spring.topic.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by keithl on 2017/11/8.
 */

public class AnnotationApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        AnnotationService service = context.getBean(AnnotationService.class);
        service.outputResult();
    }
}
