package com.xiaokunliu.study.springboot_j2ee.spring.core.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by keithl on 2017/11/8.
 */

public class EventApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(EventConfig.class);

        EventPublisher publisher = annotationConfigApplicationContext.getBean(EventPublisher.class);
        publisher.publish("event application ");
    }
}
