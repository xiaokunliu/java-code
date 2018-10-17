package com.dtrees.activemq.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * project:java-code
 * file:Consumer
 * package:com.dtrees.activemq.service
 * date:2018/10/5 上午10:11
 * author:keithl
 */
@Service
public class Consumer {

    @JmsListener(destination = "test.queue")
    public void getMessage(String text){
        System.out.println("have got the message text:"+text);
    }
}
