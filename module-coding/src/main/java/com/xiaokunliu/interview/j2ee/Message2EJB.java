package com.xiaokunliu.interview.j2ee;

/**
 * project:java-code
 * file:Message2EJB
 * package:com.xiaokunliu.j2ee
 * date:2019/9/13 16:30
 * author:keithl
 */
public class Message2EJB {

    // 消息驱动 EJB  -- 为更好实现消息的异步消息者，J2EE制订了消息驱动的Bean规范
    /**
     * MDB 是EJB与JMS的整合产品，与SessionBean相同的是，MDB也是存在于容器之中，也可以利用EJB提供的系统服务，如事务，安全和并发控制等，但是
     * MDB不能直接与客户端交互，消息驱动MDB只是一个JMS消息的异步消费者
     */

    //  无状态的SessionBean与MDB之间的关系
    /**
     *  1。 客户端与无状态的SessionBean通信的关系是直接调用的，是一种同步的通信方式，而MDB是属于消息异步通信方式，是属于消息消费者
     *  2。一般情况下，业务方法处理时间比较长，而且处理时间的可能具有一定的不确定性
     *  3。客户端调用该方法处理后无须立即获取返回结果
     */

    // 监听JMS消息目的状态的改变，MDB会做以下几件事情
    /**
     *  1。 通过onMessage方法的形参来获取JMS消息对象，并提取其中的信息
     *  2。 调用业务逻辑组件，通常就是无状态的SessionBean 来对该消息中的信息进行处理
     *
     *  person  --- send message --> jms dest --- on message touched ---> MDB  --- call business method --->  Session Bean
     */

    // 使用消息驱动MDB
    /**
     *  1。 MDB的Bean实现类必须直接（通过类声明）或者间接（通过注解注入/xml方式）来实现消息监听器接口，实现onMessage方法作为消息的异步消息消费者使用
     *  2。 MDB只能是一个public修饰的POJO，不能是其他的MDB子类
     *  3。 MDB类必须包含无参的构造器，当然如果没有为MDB类提供构造器，系统将会为其提供无参数的构造器
     *  4。 由于EJB容器会操作MDB类，因此不要使用final 或者是 abstract 修饰MDB的Bean实现类
     *  5。 MDB类不应该定义finalize()方法，若开发需要在MDB中收回资源，则应该使用@PreDestrory修饰的方法进行回收
     */


    // MDB生命周期
    /**
     *     不存在的状态
     *         |     1。 通过反射Class.newInstance创建实例
     *         |     2。 执行依赖注入
     *         |     3。 执行@PostConstruct回调方法
     *      待命状态
     *         |
     *         |     1。 执行@PreDestroy
     *         |
     *      被销毁状态
     *
     *  不存在状态：当一个MDB处于不存在状态时，也就是系统还没有创建这个MDB实例，因此这个MDB在系统中完全不存在，一般说来，EJB容器会在启动时创建一系列MDB实例，并使用
     *  类似于无状态SessionBean的EJB池来管理Bean；不仅EJB容器启动时会创建一系列MDB实例，当客户端向EJB容器发起请求，而EJB容器中的bean实例不够时也会再次创建MDB实例
     *
     *  待命状态，当EJB容器调用Class.newInstance创建实例，EJB容器将会为MDB通过注解或者xml进行依赖注入，注入完成之后还会主动调用MDB内以@PostConstruct回修饰的
     *  生命周期方法，此时可以用于"监听"指定的消息目的，当JMS客户端将JMS消息发送到消息目的时，该消息将会被传递给"池"中任意一个处于空闲的MDB，在该MDB完成对JMS消息的处理之前，
     *  该MDB不能处理其他的JMS消息，一旦这个实例完成当前任务之后，可以立即被用于处理新的消息
     *
     *  销毁状态，当EJB容器关闭或者是不需要那么多的MDB实例，系统将销毁部分或者全部的MDB实例，当EJB容器打算销毁某个MDB实例，EJB容器会先调用MDB实例中的@PreDestroy修饰的方法进行
     *  对象回调前销毁的方法，修饰的方法可以是任意的，但是不能声明抛出任何checked异常
     */

    // 事务管理和异常处理
    /**
     *   支持CMT和BMT两种事务管理，CMT事务管理MDB事务，则采用以下几种方式来修饰
     *      1。配置事务管理类型，@TransactionManagement
     *      2。配置事务管理属性，@TransactionAttribute
     *
     *   与SessionBean中的事务管理控制事务回滚，如果采用CMT事务管理方式，EJB的业务方法执行时引发了系统异常，CMT的事务管理将控制事务回滚，但是如果方法抛出了
     *   自定义的异常，将不会让事务回滚，如果希望事务发生回滚，有以下的处理方式
     *      - 定义自定义时使用@ApplicationException(rollback=true)修饰
     *      - 程序中自定义异常捕获时，调用context.setRollback(true)代码来控制事务回滚
     */

}
