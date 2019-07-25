package com.xiaokunliu.activemq.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * project:java-code
 * file:Subscriber
 * package:com.xiaokunliu.activemq.service
 * date:2018/10/5 上午10:25
 * author:keithl
 */
@Service
public class Subscriber {

    @JmsListener(destination = "test.topic", containerFactory = "jmsListenerContainerFactory")
    public void getMessage(String text){
        System.out.println("have got the message text:"+text);
    }
}
