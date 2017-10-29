package com.dtrees.datastruct.queue;

import com.dtrees.datastruct.DataStructException;

/**
 * Created by keithl on 2017/10/29.
 */

public class QueueObject {

    /**
     * 单向队列:先进先出
     */
    protected long[] arr;         // 存储数据的容器

    protected int size = 0;       // 队列的有效数据长度,初始化长度为0

    protected int front = 0;       // 队列的头,初始化的队列头为0

    protected int rear = -1;      // 队列的尾,初始化的队列尾为-1,注意初始化的时候,头和尾的指针的值不一样,-1表示初始化的时候队列没有数据

    // 默认的构造方法
    public QueueObject(){
        arr = new long[16];
    }

    // 创建指定大小的队列
    public QueueObject(int maxSize){
        arr  = new long[maxSize];
    }

    // 向队列添加数据
    public void offer(long element){
        if (isFull()){
            throw new DataStructException("当前队列已经满了,无法进行添加数据");
        }
        arr[++rear] = element;
        size++;
    }

    // 向队列移除数据
    public long poll(){
        if (isEmpty()){
            throw new DataStructException("当前队列为空,无法移除数据");
        }
        size--;
        return arr[front++];
    }

    // 查看队列当前的数据
    public long peek(){
        if (isEmpty()){
            throw new DataStructException("当前队列为空,无法获取数据");
        }
        return arr[front];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == arr.length;
    }
}
