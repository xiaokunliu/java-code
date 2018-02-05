package com.dtrees.datastruct.list.queue;

/**
 * Created by keithl on 17-5-18.
 */
public class QueueStruct {

    public static void main(String[] args) {

        // 单向队列的测试,单向队列
        QueueObject queueObject = new QueueObject(5);
        queueObject.offer(4);
        queueObject.offer(14);
        queueObject.offer(24);
        queueObject.offer(34);
        queueObject.offer(54);

        // 队列已经满5个,无法添加数据
//        queueObject.poll();     // 移除一个再添加
//        queueObject.offer(74);  // 队列未满,此时已经无法再继续向队列中添加数据,java.lang.ArrayIndexOutOfBoundsException: 5

        // 循环队列,解决上述无法继续添加的问题
        CycleQueueObject cycleQueueObject = new CycleQueueObject(5);
        cycleQueueObject.offer(4);
        cycleQueueObject.offer(14);
        cycleQueueObject.offer(24);
        cycleQueueObject.offer(34);
        cycleQueueObject.offer(54);

        // 移除队列的一个数据
        long value = cycleQueueObject.poll();
        System.out.println(String.format("循环队列删除的数据:%d",value));

        // 添加队列的一个数据
        cycleQueueObject.offer(74);

        // 遍历循环队列
        while (!cycleQueueObject.isEmpty()){
            System.out.println(cycleQueueObject.poll());
        }

        // TODO 双端队列

        // 循环队列:判断是否有重复元素（在一个无重复的元素队列中）
    }
}
