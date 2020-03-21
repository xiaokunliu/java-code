package com.xiaokunliu.interview.j2ee;

/**
 * project:java-code
 * file:Web2EJB
 * package:com.xiaokunliu.j2ee
 * date:2019/7/30 9:46 PM
 * author:keithl
 */
public class Web2EJB {

    //EJB -- 实际开发中也很少会用到EJB，纯属了解基本原理知识
    /**
     * 参考：https://blog.csdn.net/qq_19865749/article/details/75648083
     * 企业JavaBeans或者企业Bean是实现业务逻辑模块的代码，包含字段和方法，可以把企业bean看作基础构件，可以单独使用，也可以与其他企业Bean一同用来执行JavaEE服务器上的业务逻辑
     *
     * 什么是EJB（服务集群 / 企业开发）
     * 商务软件的核心部分是它的业务逻辑。业务逻辑抽象了整个商务过程的流程，并使用计算机语言将他们实现
     *
     * 所谓业务逻辑
     * J2EE 对于这个问题的处理方法是将业务逻辑从客户端软件中抽取出来，封装在一个组件中。这个组件运行在一个独立的服务器上，客户端软件通过网络调用组件提供的服务以实现业务逻辑，而客户端软件的功能单纯到只负责发送调用请求和显示处理结果
     *
     * 将业务逻辑从客户端软件中抽取出来，封装在组件中……运行在一个服务器上
     * 这个就是把原来放到客户端的"类"，拿出来不放到客户端了，放到一个组件中，并将这个组件放到一个服务器上去运行
     *
     * 即把你编写的软件中那些需要执行制定的任务的类，不放到客户端软件上了，而是给他打成包放到一个服务器上
     *
     * EJB 的实现技术
     * EJB 是运行在独立服务器上的组件，客户端是通过网络（RMI/http/RPC）对EJB 对象进行调用的。
     * 在Java中，能够实现远程对象调用的技术是RMI，而EJB 技术基础正是RMI。通过RMI 技术，J2EE将EJB 组件创建为远程对象，客户端就可以通过网络调用EJB 对象了
     */

    // 架构流程类似如下：
    /**
     *                              A 服务器（EJB A）                数据库A
     *                              B 服务器（EJB B）                数据库B
     *                              C 服务器（EJB C）                数据库C
     *     客户端软件（JSP）          D 服务器（EJB D）                数据库D
     *                              E 服务器（EJB E）                数据库E
     *                              F 服务器（EJB F）                数据库F
     *
     *   分析：
     *      现在客户端功能需要以上的各个EJB的功能，分别通过RMI的方式调用服务，同时不同的组件连接到对应的数据库降低数据库压力，同时带来了数据一致性问题，这个时候其他服务
     *      调用需要通过走外网的方式调用其他组件的数据库，这个时候就会产生客户端软件调用服务产生网络超级严重的延迟现象，上述除了客户端调用服务端是1-N，而服务器端与数据库端是N-N
     *      调用方式，这中间会产生网络严重的延迟现象，因此由EJB进行演变SOA再到微服务再到现在的Service Mesh一个分布式架构
     */

    /**
     * EJB分类：
     *    会话Session Bean，相当于一个允许客户端调用的门面模式，调用方与被调用方之间进行的会话，相当于调用方需要通过一个会话Bean提供的方法来与被调用方之间进行复杂的特性
     *    门面模式设计模式 -- 参考：https://blog.csdn.net/xingjiarong/article/details/50066133
     *    消息驱动Bean (MDB),本质上是一个异步的JMS消息消费者
     */


    // Session Bean
    /**
     * Session Bean 代表一个可处理应用中业务逻辑的完整组件，主要包含了各种业务逻辑的实现代码
     * Session Bean 与 Spring POJO Bean相比：EJB交由EJB容器实现完成
     *      1）并发和线程安全，运行在EJB容器中，因此开发EJB需要有一定的规范，同时容器需要提供EJB组件的支持
     *      2）方便的ws支持，只有无状态的bean才能对外进行ws服务
     *      3）事务和安全管理
     *      4）存在有状态与无状态的Session Bean,无状态的bean更容易实现扩容，有状态的服务需要在扩容的时候增加一份状态服务的维护
     */

    // Message Bean
    /**
     *  MDB：就是JMS消息的异步消费者，就相当于一个事件机制中的事件监听机制，区别在于：事件监听器监听的是事件源上的事件，尔消息驱动Bean监听的是JMS消息的到来
     *
     *  MDB是由无状态的Session Bean演变而来，具有共同的特征如下：
     *      1）MDB不会保留任何客户端的状态，消息驱动Bean对所有客户端都是等同的
     *      2）消息驱动Bean可以处理来自多个客户端的消息
     */

    // Session Bean ===  start  ====

    /**
     *  EJB3 开发一个无状态的Session Bean 规范
     *  1）至少具有一个业务接口，该业务接口既可以是本地的local，也可以是Remote的接口
     *  2）Session Bean类不能是抽象类，也不能是final修饰的最终类，必须实现业务接口，因此它必须实现业务接口所定义的方法
     *  3）Session Bean的Bean类必须提供无参数的构造器，EJB容器会无参数构造器进行创建实例对象
     *  4）Session Bean可以是任何其他的子类
     *  5）业务方法不要以ejb开头，应当避免业务方法和ejb2中的ejbCreate。。。特殊意义的方法混淆
     *  6）Session Bean中的业务方法可以在Bean类或者其父类中的定义
     */

    /**
     * 客户端通过Remote调用EJB
     *  1。 EJB对远程客户端透明，远程客户端通过JNDI查找获得RJB之后，面向EJB业务接口编程即可
     *  2。 远程客户端无须与EJB运行于同一个JVM中，远程客户端可以是普通Web组件，也可以是其他客户端软件
     *
     *  客户端通过本地调用EJB
     *  1。 本地客户端和EJB必须运行于同一个JVM中
     *  2。 本地客户端通常与EJB位于同一个Java EE应用中，本地客户端往往是该应用内的web组件或者其他EJB组件
     *
     *  编码规范：
     *  1。EJB业务接口的接口名称通常就是该业务组件的组件名称，如Account
     *  2。EJB Bean实现类的类名通常是在业务接口名之后添加Bean
     */

    /**
     * EJB3 注解说明
     * 1。 @Remote           修饰远程调用的EJB业务接口或者Bean类
     * 2。 @Local            修饰本地
     * 3。 @Stateful         有状态的Session Bean，指定name为ejb的名称，mappedName指定该ejb全局的名称，ejb容器会根据这个名称生成JNDI名
     * 4。 @Stateless        无状态的
     * 5。 @MessageDriven    修饰消息驱动的Bean，同上name和mappedName，以及可以指定多个activationConfig属性，属性值是多个@ActivationConfigProperty
     * 6。 @ActivationConfigProperty，修饰消息驱动相关的属性配置参数，propertyName = "mailFolder", propertyValue = "INBOX"
     */

    /**
     * Session Bean 生命周期
     *  1。无状态的Session Bean生命周期
     *      1）EJB容器开始创建无状态Session Bean的实例
     *      2）EJB容器对EJB实例执行依赖注入
     *      3）EJB容器调用EJB内以@PostConstrust修饰的生命周期方法
     *      4）EJB进入待命状态
     *      5）EJB容器调用EJB内以@PreDestory修饰的生命周期方法来回收该EJB的资源
     *      6）EJB实例被垃圾回收
     *
     *  2。 有状态的Session Bean生命周期
     *      1）EJB容器开始创建无状态Session Bean的实例
     *      2）EJB容器对EJB实例执行依赖注入
     *      3）EJB容器调用EJB内以@PostConstrust修饰的生命周期方法
     *      4）EJB进入待命状态
     *      5) EJB执行@PrePassivate回调方法进入去活状态
     *      6）EJB执行@PostActivate回调方法进入待命状态
     *      7）如果EJB是处于待命状态，客户端调用@Remove方法，将执行@PostDestory方法回调将实例进行销毁
     *      8）如果是EJB是处于去活状态，一旦超时也将会被垃圾回收销毁
     *
     *  3。 定制的Session Bean的生命周期行为
     *    @PostConstuct:修饰的方法将会在EJB创建之后被EJB容器调用
     *    @PreDestroy:修饰的方法将会在EJB销毁之前被EJB容器调用
     *    @PostActivate:有状态的Bean从去活状态转换为待命状态之前被调用
     *    @PrePassivate:待命状态转换为去活状态之前被调用
     */

    /**
     * Session Bean中的生命周期方法必须满足以下几个要求，
     *      1. 方法名称是任意的
     *      2。 不能定义形参
     *      3。 方法返回值是void
     *      4。 不能抛出checked异常
     *      5。 相同类型的生命周期方法只能被定义一个，比如@PostConstuct修饰的方法最多只能有一个
     */

    /**
     * Session Bean 使用事务
     *      1。 用于封装底层实体和JPA，用于访问底层的实体，可以成为Entity Access Object对象，本质上的功能就是DAO
     *      2。 主要充当业务组件，是底层DAO对象的Facade（门面），系统控制器将调用它们的业务方法来处理用户请求
     *
     *  TransactionManagementType.CONTAINER     --    指定使用容器来管理事务
     *  CMT事务：容器管理事务，负责整个业务Bean的事务，通过注解或者xml配置的方式来配置事务属性，EJB容器会自动为容器中的Session Bean增加事务控制
     *  CMT事务的边界总是以方法的开始，结束作为边界
     *  CMT事务管理意味着容器会接管EJB业务方法中的事务，因此开发者不需要在EJB业务方法中调用任何开始，结束事务的方法
     *
     *  TransactionManagementType.BEAN       --   指定使用EJB的Bean来管理事务
     *  BMT事务：使用Bean（EJB的Bean方式）管理事务，程序员需要自己控制事务边界，或者对事务进行灵活控制，则可以采用BMT事务管理
     *  应用场景
     *      1）只需要对方法中某一个片段进行事务控制，而不是对整个方法进行事务控制，那么可以考虑使用CMT事务方式
     *      2）有状态的Session Bean需要跨方法调用事务，也就是将多个方法放在同一个事务中进行维护
     *
     */

    /**
     * 拦截器  -- AOP
     *   最常见的横切服务，事务管理和安全检查，EJB容器提供的CMT支持解决事务管理问题，JAAS以声明式解决安全检查，权限控制问题
     *   EJB3 开发拦截器步骤：
     *      1）定义一个拦截器类，这个类没有特殊之处，主要使用@AroundInvoke修饰一个具有public Object xxxx(InvocationContext ctx) throws Exception签名的方法即可
     *      2）在所有需要被EJB3的Bean实现类，业务方法上使用@Inteceptors修饰
     *      3）排除拦截，添加@ExcludeClassInteceptors修饰该方法
     */

    /**
     * 依赖注入：使用注解的方式注入
     *      EJB注入，EJB容器会自动将对应的EJB注入该Field或者setter方法中
     *      资源注入，EJB容器会负责将使用@Resource注释的bean进行初始化操作
     */

    // EJB的引用，即通过注入之后可以在业务类中定义并引入实例进行使用

    // 定时器 -- 进行任务调度
    /**
     *  任务调度
     *     1。让指定任务在固定的时刻执行
     *     2。让指定任务在指定时间之后开始执行
     *     3。周期性执行指定任务
     */

    // Session Bean ===  end  ====
}
