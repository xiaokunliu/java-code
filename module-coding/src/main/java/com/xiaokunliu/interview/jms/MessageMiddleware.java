package com.xiaokunliu.interview.jms;

/**
 * project:java-code
 * file:Middleware
 * package:com.xiaokunliu.jms
 * date:2018/10/4 上午10:49
 * author:keithl
 */
public class MessageMiddleware {

    /**
     * MOM基本功能:将信息以消息的形式，从一个应用程序传送到另一个或多个应用程序。
     MOM主要特点:
     1:消息异步接受，类似手机短信的行为，消息发送者不需要等待消息接受者的响应，减少软件多系统集成的耦合度;
     2:消息可靠接收，确保消息在中间件可靠保存，只有接收方收到后才删除消息，多个消息也可以组成原子事务
     n 消息中间件的主要应用场景:
     ``在多个系统间进行整合和通讯的时候，通常会要求: 1:可靠传输，数据不能丢失，有的时候，也会要求不能重复传输; 2:异步传输，否则各个系统同步发送接受数据，互相等待，造成系统瓶颈
     */
}
