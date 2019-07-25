##### Java面试

> 熟悉基本的数据结构和算法、网络协议、操作系统和软件工程原理
    * 数据结构
    * 八大排序
    * 常见的算法
    * 算法策略:贪婪、分治法、回溯、动态规划、随机算法
    * 网络协议:CDN(作用和原理)、HTTP(组成+作用+原理)、TCP/IP(作用+原理)
    * 操作系统:进程 + 内存 + 调度 + IO/文件  + 嵌入式  + 安全


> 熟悉 Java 面向对象编程
    * 面向对象的本质:将现实生活中的事物进行抽象并作封装
    * Java核心关键字:final、finalize、volatile、transient、static、
    * 面向对象编程的三个特征:封装、继承、多态
    * 对象的三个特性:对象的行为、对象的状态、对象的标识
    * 异常处理机制
    * 泛型与反射


> 熟悉Java的IO/文件操作
    * BIO/NIO/AIO
    * netty
    * mina

> 熟练Java集合
    * HashTable 与 HashMap的区别
    * HashMap 与 TreeMap的区别
    * List:ArrayList/StringList/Vector/LinkedList/JSONArray/SortableList/CopyOnWriteArrayList
    * Set:
    * Queue:
        
> 多线程并发编程
    * 线程方法:sleep()/yield()/suspend()/
    * 资源方法:wait()/notify()/notifyAll()
    * 阻塞队列:
        * 什么是阻塞队列 
        * 阻塞队列:ArrayBlockingQueue、LinkedBlockingQueue、PriorityBlockingQueue、DelayQueue、SynchronousQueue、LinkedTransferQueue、LinkedBlockingDeque
    * 锁的分类:读锁和写锁
   
> JVM
    * JVM加载类的原理
    * JVM算法
    
> Spring框架的核心
    * IOC:
        * 什么是装配
        * IOC如何定义
        * IOC作用
    * AOP
        * 原理
        * 作用
    
> Spring MVC的核心
    * 原理

> Hibernate
    * 一级缓存和二级缓存的区别
    

> Spring Boot
    * 组成
    * 原理
    * 作用
    * 带来的问题又是什么 -- 引入Spring Cloud
   
   
> MyBatis
    * 原理
    * 作用
    * SqlSession的生命周期
   
    
> 分布式与消息队列
    * ActiveMQ
    * Zookeeper
    * Kafka
    * Storm/Spark
    * MapReduce
    
    
> 软件版本管理与测试
    * GIT/SVN
    * Maven/Gradle
    * Jenkins/Nexus
    * 自动化测试,sonar
    
> Docker与K8S
    

> 工作中遇到的问题
    * SQL优化
        * 慢查询的日志定位SQL查询的时长（等待时长 + 实际处理的时长）
        * 要判断查询慢是由于阻塞导致还是本身SQL执行的时长的确很长
        * 阻塞导致的话,要定位到是什么原因,一般情况下是mysql进行锁的操作导致其他进程处于等待,锁:读锁和写锁,范围上的:表锁和行级锁,还有列锁
        * sql本身出现的查询慢的原因:
            * 是否查询不必要的数据列
            * 是否需要建立索引
            * 第三建立的数据库字段是否存在大数据段类型
            * SQL是否需要拆分,是否可行
    * OutOfMemory错误,如何排查
        * 第一是查看日志报出的OOM错误提示,根据提示来定位,排查到是Java Heap Space 
        * 
    * 重构面临的问题:修改代码,TDD
        * 
    * 多个进程job转换为一个web容器来管理
    * 并发安全问题
    * 动态规划
    * 事务控制
        * 分布式事物控制
    * 代码审查
        1. 保证业务可行;
        2. 
    * 如何带人
    * 面对问题的时候,自己解决问题的思路是什么
    * 一个请求的URL如何建立索引快速定位到这个URL
    * 与产品经理沟通需求
