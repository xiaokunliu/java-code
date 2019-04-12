package com.dtrees.study.springboot_j2ee.spring.core.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by keithl on 2017/11/8.
 * 事件发布类型
 */
@Component
public class EventPublisher {

    @Autowired
    private ApplicationContext applicationContext;

    public void publish(String message){
        applicationContext.publishEvent(new DefineEvent(this,message));
    }
}
