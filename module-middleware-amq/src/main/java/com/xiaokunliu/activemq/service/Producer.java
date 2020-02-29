package com.xiaokunliu.activemq.service;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * project:java-code
 * file:Producer
 * package:com.xiaokunliu.activemq.service
 * date:2018/10/5 上午9:04
 * author:keithl
 */
@Service
public class Producer {

    @Resource
    private JmsMessagingTemplate messagingTemplate;

    public void sendMessage(String destName, String message){
        Destination destination = new ActiveMQQueue(destName);
        messagingTemplate.convertAndSend(destination, message);
        System.out.println("send message to destName:"+destName+",message:"+message);
    }
}
