package com.xiaokunliu.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Enumeration;

/**
 * project:java-code
 * file:TestJMSServer
 * package:com.xiaokunliu.activemq
 * date:2018/10/4 下午10:11
 * author:keithl
 */
public class TestJMSQueueClient {

    static String uri = "tcp://127.0.0.1:61616";

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ActiveMQConnectionFactory(uri);
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("jms_queue");

        MessageConsumer consumer = session.createConsumer(destination);

        // 同步阻塞
        // 获取消息属性
        Enumeration<String> names = connection.getMetaData().getJMSXPropertyNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            System.out.println("get JMS name:"+name);
        }


        TextMessage message = null;
        while ((message = (TextMessage)consumer.receive()) != null){
            session.commit();
            System.out.println(message.getText());
        }
    }
}
