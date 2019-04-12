package com.dtrees.jms;


import com.sun.xml.internal.ws.message.stream.StreamMessage;

/**
 * project:java-code
 * file:P2P
 * package:com.dtrees.jms
 * date:2018/10/3 下午5:55
 * author:keithl
 */
public class JMS {

    // 什么是JMS？

    /**
     *  P2P消息发送
     *      1. 通过JNDI查找来获取JMS连接工厂
     *      2. JMS连接工厂创建JMS连接
     *      3. 使用JMS连接创建JMS会话
     *      4. JMS消息会话创建消息生产者
     *      5. JMS消息会话创建空的JMS消息
     *      6. JMS消息调用自身的方法填充内容
     *      7. 通过JNDI查找获取JMS消息目的
     *      8. 消息生产者将消息投递到指定的JMS服务的消息组件
     *      9. 关闭JMS资源
     */

    /**
     *  P2P同步接收
     *      1. 通过JNDI查找来获取JMS连接工厂
     *      2. JMS连接工厂创建JMS连接
     *      3. 使用JMS连接创建JMS会话
     *      4. 通过JNDI查找获取JMS消息的Topic
     *      5. JMS会话根据指定的JMS消息Topic创建对应的消息消费者
     *      6. JMS消费者消费消息
     *      7. 关闭JMS资源
     */

    /**
     *  P2P异步接收（采用监听者模式进行监听接收消息）
     *  采用监听器的机制来监听消息Topic，当有消息抵达消息目的时，JMS消费者将自动触发它所对应的监听器方法，即JMS异步消费实际上就是为JMS消费者绑定一个消息监听器
     */


    /**
     * 发布订阅模式
     *      publisher1                                          Consumer1
     *                                                          Consumer2
     *                            Topic（MessageStore）         Consumer3
     *                                                          Consumer4
     *      publisher2                                          ConsumerN
     */

    // 发送可靠的JMS消息，即订阅到Topic的客户端如果离线后重新登录将无法获取离线-重新登录期间的消息，为了避免这种情况，可以在JMs中添加消息上的客户端ID，即客户端唯一的标识符


    // JMS的消息类型
//    StreamMessage:这种类型的消息内容由序列化对象流组成，读写消息需要对消息内容进行序列化
//    MapMessage：这种类型的消息内容由多个key-value的键值对组成，该消息内容就类似与HashMap。所包含的数据是无须且每个key都是唯一的
//    TextMessage：消息内容局势普通字符串
//    ObjectMessage: 该消息内容是序列化后的对象
//    BytesMessage:该消息内容是原始的字节流，只有当客户端需要完全控制原始消息格式时猜考虑


    /**
     * JMS 消息头和消息属性
     *      Message：        标准的消息头
     *                     可扩展的消息属性
     *                      消息主体内容
     */

    // 消息头
    /**
     * set方法设置：
     * JMSDeliveryMode：指定消息的投递方式，消息模式：（持久化）PERSISTENT 和 （非持久化）NON_PERSISTENT
     * JMSMessageID：JMSMessageID是一个String类型值，它唯一地标识了一条消息，指定消息的唯一标识
     * JMSPriority：指定消息的优先级
     * JMSTimestamp：JMS提供者接收消息的时间，而不是该消息实际传送的时间。这条消息头用于确定发送消息和它被消费者实际接收的时间间隔。时间戳是一个以毫秒来计算的long类型时间值
     * JMSExpiration：一个Message对象的有效期用来防止把过期的消息传送给消费者
     *
     * 应用服务器设置：
     * JMSRedelivered：表示该消息将被重新传送给消费者。如果该消息被重新传送，JMSRedelivered消息头就为true，否则为false。如果一个消费者未能确认先前传送的消息，或者JMS提供者并不确定消费者是否已经接收到该消息时，就可以将这条消息标记为重新传送
     *
     * 应用程序设置（开发者分配的消息头）
     * JMSReplyTo：一个JMS消息生产者可能会要求消费者对一条消息做出应答。JMSReplyTo消息头包含了一个javax.jms.Destination，标明了JMS消费者应该应答的地址。在使用请求/应答场景时，通过这条消息头属性可以进一步实现消息生产者和消息消费者之间的去耦
     * JMSCorrelationID：JMSCorrelationID提供了一个消息头，用于将当前的消息和先前的某些消息或应用程序特定的ID关联起来
     * JMSType：JMSType是由JMS客户端设置的一个可选消息头。它的主要作用是标识消息结构和有效负载的类型。请注意，这个消息头并未指明被发送的消息类型（MapMessge，TextMessage等），而是JMS提供者使用的内部消息仓库中的一个条目。一些MOM系统（比如IBM的WebSphere MO）将消息体视为连续的字节流
     */

    // 消息的确认方式
    /**
     * AUTO_ACKNOWLEDGE：自动确认方式
     * CLIENT_ACKNOWLEDGE：客户端确认方式
     * DUPS_OK_ACKNOWLEDGE：延迟确认方式
     * NO_ACKNOWLEDGE：无须确认方式，这种确认方式不要求消息消费者对收到的消息进行确认
     * MULTICAST_NO_ACKNOWLEDGE：无确认方式，通过IP广播方式把消息传递给主题订阅者的情况
     */

    // 消息选择器
    /**
     * 消息会话Session根据指定的消息Topic来创建一个消息消费者，并通过消息选择器过滤出符合条件的消息发送给指定的消息消费者
     * createConsumer(Destination dest, String messageSelector)
     */

    // 消息的临时Topic
    // 应用场景：就是当JMS生产者向JMS服务器发送消息时，将JMSReplyTo消息头设置为临时创建的消息目的，JMS消费者收到消息后，向该临时目的发送一个响应
//    TemporaryQueue   createTemporaryQueue: 创建临时队列
//    TemporaryTopic   createTemporaryTopic：创建临时的消息Topic

    // JMS临时目的有几点说明
    /**
     * 1。客户端不应该试图在临时目的基础上创建可靠的消息订阅
     * 2。每个临时目的只能依附于单个的JMS连接，且只能以该JMS连接来创建使用临时目的的JMS消费者
     * 3。临时目的会随着服务器的重启而自动消失，因此不要希望临时目的会持久化地保存消息，任何发送到临时目的的持久化消息都会被JMS服务器自动转为NON_PERSISTENT传递模式
     */

    // JMS和事务

    /**
     * 1。 使用事务性的Session（单机操作）
     *      对于消息生产者而言，当它使用事务性session时，其所发送的消息将会被缓存起来，在事务提交之前，消息消费者不会接收到任务未提交的消息，当消息生产者完成一次业务处理逻辑之后，
     *      生产者提交事务，提交之前所有发送的消息才会被"整体性"地传递到消息消费者，若事务回滚，则JMS服务器将直接丢弃所有缓存的消息，这些消息也不会被传送到别的消费者
     *      对于消费者，使用事务性session可以来控制消息的确认方式，正如使用CLIENT_ACKNOWLEDGE确认方式一样，消费者接收并消费消息成功之后，消费者提交事务，此时才会向
     *      生产者确认收到所有的消息，若事务回滚，JMS服务器会把所有消息退还给相关的消息队列和主题
     *
     * 2。 在JTA全局事务中使用JMS（集群操作）
     *      先通过JNDI查找获取JTA服务器的引用，然后现实打开事务，当所有的JMS操作，JDBC操作，EJB操作等执行完毕后，应用程序提交或回滚JTA事务即可
     */

    /**
     * Broker:相当于一个ActiveMQ服务器实例
     *
     *
     */
}