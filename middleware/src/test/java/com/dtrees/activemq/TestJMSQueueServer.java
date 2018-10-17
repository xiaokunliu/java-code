package com.dtrees.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * project:java-code
 * file:TestJMSServer
 * package:com.dtrees.activemq
 * date:2018/10/4 下午10:11
 * author:keithl
 */
public class TestJMSQueueServer {

    static String uri = "tcp://127.0.0.1:61616";

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ActiveMQConnectionFactory(uri);
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("jms_queue");

        MessageProducer producer = session.createProducer(destination);

        for (int i=0; i< 10; i++){
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText("i="+i+",the text message is broker");

            producer.send(textMessage);
        }

        session.commit();
        producer.close();
        session.close();
        connection.close();

        System.out.println("send message done ..");
    }
}
