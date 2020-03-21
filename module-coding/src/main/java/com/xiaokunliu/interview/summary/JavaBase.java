package com.xiaokunliu.interview.summary;

/**
 * Created by keithl on 2017/10/26.
 */

public class JavaBase {

    // java基础
    // 数据结构与集合
    public static void main(String[] args) {
//        Collection
    }

    /**
     * 数据结构与集合（看下《突破Java程序员16课》）
     *      线性表:顺序存储结构和链式存储结构(单链表、循环链表、双端链表)
     *          特点:1)线性表的长度可以动态改变,数组不行
     *              2)线性表可以插入和删除元素,数组无法插入元素
     *              3)
     *
     * 集合
     * List:底层是由线性表实现的
     *      ArrayList 与 LinkedList,前者主要是基于顺序线性表(数组)的数据结构实现,后者主要是基于链式线性表的数据结构实现,两者均实现栈和队列两种数据结构
     * Map:是由数组和链表两种数据结构,数组是查找快,但是插入和删除慢,链表查找慢,插入和删除快
     *      HashMap 与 HashTable,HashMap 与 TreeMap
     *      TreeSet 与 TreeMap是基于树的数据结构实现的
     *      ConcurrentMap(ConcurrentHashMap,ConcurrentSkipListMap)
     * Queue:队列,先进先出
     */

    /**
     * JVM
     *  强引用,通过new的形式创建对象,默认形式,也是会出现JVM内存泄露的情况
     *  软引用,通过SoftReference类来实现,当内存不足的时候JVM将回收Java对象的内存空间,但是容易造成数据丢失
     *  弱引用,与软引用相似,但是生存期更短,并当垃圾回收机制运行时不论内存是否足够都会强制回收
     *  虚引用,跟踪对象被垃圾回收的状态,程序可以检查虚引用关联的引用队列中是否包含已经指定的虚引用
     *
     * JVM 类加载机制
     *  类的生命周期:loading -- verification -- preparation -- resolution -- initialization -- use -- unloading
     *
     * JVM 内存结构
     *        堆内存               方法区                 栈
     *     年轻代 + 老年代          永久代                缓存
     *  年轻代:Eden空间 + From Survivor + To Survivor
     *
     *  JVM 运行数据区
     *     方法区  +   Java栈   +   本地方法栈     +    堆     +     程序计数器(唯一一个没有OOM的区域)
     *
     *  堆:是被所有线程共享的一块区域,几乎所有的对象实例都在这里分配内存
     *  方法区:用于存储已经被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的代码等数据
     *  程序计数器:可以看做是当前线程所执行的字节码的行号指示器,此内存区域是唯一一个在JVM虚拟机中规范中没有规定任何OutOfMemoryError情况的区域
     *  虚拟机栈:为虚拟机执行Java方法（字节码）的服务
     *  本地方法栈:为虚拟机所使用到的Native方法服务
     *
     *  socket的线程模型
     *  NIO
     *  Netty框架
     *
     *  线程
     *      同步和异步
     *      并发和并行
     *      临界区
     *      阻塞和非阻塞
     *      饥饿:如果线程存在优先级,则优先级低的线程将可能永远执行不到
     *      无饥饿:不存在线程优先级,即锁是公平的
     *      无障碍:
     *      无锁:
     *      无等待
     *      锁的种类:读写锁,乐观锁和悲观锁
     *  线程的状态
     *      初始状态new -- 可运行状态start  -- 运行中的状态run  -- 阻塞状态sleep、join -- 锁池状态sync  -- 等待状态wait  --  结束状态(run方法结束/main方法结束)
     *  创建与启动线程的方式
     *      继承Thread、实现Runnable接口、使用Future模式创建线程
     *
     *
     */
}
