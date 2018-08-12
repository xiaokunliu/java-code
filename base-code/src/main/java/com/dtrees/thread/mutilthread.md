#### 并发开发
参考:http://ifeve.com/
* 线程安全
    * 当多个线程访问同一个共享资源的时候,这个共享资源所表现的资源消费情况是属于正常消费行为的,则可以说资源消费行为是属于线程安全的
    * synchronized:可以在静态方法（锁为类对象）、对象方法（锁为类实例对象）、代码块（任意唯一的资源）
    * 总结:当多个线程访问共享资源的消费行为方法时,将会以CPU分配的先后顺序进行排队消费,一个线程想要执行synchronized修饰的方法里面的代码
        * 首先是获得锁,如果拿到锁,便会执行锁中的代码块;
        * 若拿不到锁便会不断尝试地去获取锁,直到获取锁为止;
        * 多个线程同时竞争一把锁,称为锁竞争问题

* 同步类容器与并发类容器
    * 相同点:都是属于线程安全的,即在多线程并发环境下能够保持共享数据的一致性
    * 不同点:同步类操作是对整个容器方法或者是对当前线程操作进行加锁,是更为粗粒度级别的锁,而并发类容器是针对更小粒度级别的锁,
    比如针对一个方法中的某一个代码或者根据存储的结构进行分解层多个任务,抽出相同的任务并加锁操作
 
* ConcurrentMap
    * ConcurrentHashMap
    * ConcurrentSkipListMap:有序的并发Map

* Copy On Write容器:读写分类的不同容器,在进行写容器的时候先复制一份容器,往副本容器进行写操作,原容器引用地址不变,写操作之后的容器重新指向原容器的引用
    * 应用场景:读多写少
    * CopyOnWriteArrayList
    * CopyOnWriteArraySet
    
* Queue 
    * ConcurrentLinkedQueue
    * 阻塞队列
        * ArrayBlockingQueue:基于数组实现的阻塞队列,是一个有界的阻塞队列,超过界限将报错误,队列已满
        * LinkedBlockingQueue:基于链表实现的阻塞队列,是一个无界的阻塞队列
        * PriorityBlockingQueue:通过Comparable接口来实现队列的优先级,是一个无界队列,每次调用take方法的时候会把优先级最高的数据拿出来
        * DelayQueue:该队列中必须实现Delayed的接口,没有大小限制的队列,适用于缓存超时的数据进行移除,任务超时处理,空闲连接的关闭
        * SynchronousQueue:没有缓冲的队列
        
* 线程设计模式
    * Future模式:异步处理机制,即提交一个线程异步处理,类似Ajax的异步处理机制
    * Master-Worker并行设计处理的模式
    * 生产者和消费者模式

* CAS 的含义是“我认为原有的值应该是什么，如果是，则将原有的值更新为新值，否则不做修改，并告诉我原来的值是多少”
CAS有3个操作数，内存值V，旧的预期值A，要修改的新值B。当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则返回V。这是一种乐观锁的思路，它相信在它修改之前，没有其它线程去修改它


* JDK多任务执行框架
    * Executors框架
        * newFixedThreadPool
        * newSingleThreadExecutor
        * newCachedThreadPool
        * newScheduledThreadPool
    * 自定义线程池

* 线程AQS 
    * Concurrent.util
        * CountDownLatch
        * CyclicBarrier
        * FutureTask
        * Semaphore
        * 高并发
            * PV:网站中访问量
            * UV:用户访问量
            * QPS:每秒查询数
            * RT:响应时间
    * 重入锁、读写锁
        * 重入锁,ReentrantLock
        * 读写锁,ReadLock（读锁）可以并发访问,读读共享,读写和写写锁互斥
    
* Disruptor并发框架
    * 高性能异步处理框架
    * https://zhuanlan.zhihu.com/p/23863915

