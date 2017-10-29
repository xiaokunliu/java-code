package com.dtrees.datastruct.queue;

import com.dtrees.datastruct.DataStructException;

/**
 * Created by keithl on 2017/10/29.
 */

public class CycleQueueObject extends QueueObject{

    /**
     * 循环队列:
     *  1.入队时尾指针向前追赶头指针
     *  2.出队时头指针向前追赶尾指针
     *  3.队空和队满时头尾指针均相等
     *  无法通过条件front==rear来判别队列是"空"还是"满",而是通过size的值来判断
     */
    // 默认的构造方法
    public CycleQueueObject(){
        arr = new long[16];
    }

    // 创建指定大小的队列
    public CycleQueueObject(int maxSize){
        arr  = new long[maxSize];
    }

    // 队列添加数据
    @Override
    public void offer(long value) {
        // 如果队列已经满,无法插入数据
        if (isFull()){
            throw new DataStructException("队列已经满,无法添加数据");
        }
        // 如果队列未满,当前的尾指针指向了队列存储的容器最后一个下标,将尾指针重新设置为-1,即循环使用数据
        if (rear == arr.length - 1){
            rear = -1;
        }
        size++;
        arr[++rear] = value;
    }

    // 队列删除数据
    @Override
    public long poll() {
        // 如果队列是空的,则无法删除数据
        if (isEmpty()){
            throw new DataStructException("队列已经为空,无法删除数据");
        }
        // 移除队列中的数据
        long value = arr[front++];
        // 判断此时的头指针是否已经溢出容器的大小,如果是的话将指针重新设置为0
        if (front == arr.length){
            front = 0;
        }
        size--;
        return value;
    }
}
