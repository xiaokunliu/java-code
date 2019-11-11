package com.xiaokunliu.activemq.service;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * project:java-code
 * file:Publisher
 * package:com.xiaokunliu.activemq.service
 * date:2018/10/5 上午10:24
 * author:keithl
 */
@Service
public class Publisher {

    @Resource
    private JmsMessagingTemplate messagingTemplate;

    public void sendMessage(String destName, String message){
        Destination destination = new ActiveMQTopic(destName);
        messagingTemplate.convertAndSend(destination, message);
        System.out.println("send message to topic destName:"+destName+",message:"+message);
    }
}
