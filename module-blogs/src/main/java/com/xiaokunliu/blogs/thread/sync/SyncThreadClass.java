package com.xiaokunliu.blogs.thread.sync;

/**
 * date:2020/1/6 21:52
 * author:keithl
 * desc: business desc etc.
 */
public class SyncThreadClass {

    private int count;

    public static synchronized void set() {
        // set code ...
    }

    public static synchronized void get() {
        // get code ...
    }

    public static void lockCodeStaticMethod() {
        // concurrent executed 并发执行
        System.out.println("prepare resources .....");

        // 同步代码块，当执行的其中一个线程获取lock锁之后，仅运行该线程执行以下的代码，其他线程没有获取lock锁只能处于阻塞blocked状态
        //由于该方法是类方法，加载到jvm中只有一份Class类实例，为保证锁的唯一性，可以使用当前类的class对象作为锁，但并非唯一作为锁的方案
        synchronized (SyncThreadClass.class) {
            System.out.println("consume resources ....");
        }

        // 并发执行
        System.out.println("release resources");
    }

    /**
     * // 基于类实例的同步
     * 控制当前方法只能有一个线程执行，其他线程只能处于阻塞状态
     */
    public synchronized void add() {
        // 计数器加1
        count++;
    }

    public synchronized void subtract() {
        // 计数器加1
        count++;
    }

    /**
     * 控制方法代码块中部分同步执行逻辑
     */
    public void lockCodeMethod() {
        // concurrent executed 并发执行
        System.out.println("prepare resources .....");

        // 同步代码块，当执行的其中一个线程获取lock锁之后，仅运行该线程执行以下的代码，其他线程没有获取lock锁只能处于阻塞blocked状态
        // 锁对象必须是相对于该方法是唯一的，由于该方法是实例方法，因此可以使用this（当前类实例对象）作为锁对象，但并非唯一作为锁的方案
        synchronized (this) {
            System.out.println("consume resources ....");
        }

        // 并发执行
        System.out.println("release resources");
    }
}
