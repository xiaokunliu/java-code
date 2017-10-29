package com.dtrees.datastruct.stack;

import com.dtrees.datastruct.DataStructException;

/**
 * Created by keithl on 17-5-18.
 */
public class StackObject {

    /**
     * 栈的特点:后进先出
     */
    private long[] arr;          // 数组存放数据
    private int top = -1;        // 表示栈顶,初始化的栈顶没有指向任何一个数组元素,用-1表示

    public StackObject(){
        arr = new long[16]; // 默认
    }

    // 创建指定大小的栈容器
    public StackObject(int maxSize){
        arr = new long[maxSize];
    }

    // 添加数据
    public void push(long value){
        if (isFull()){
            throw new DataStructException("已经达到栈顶,无法存放数据");
        }
        arr[++top] = value;
    }

    // 移除栈中的数据
    public long pop(){
        if (isEmpty()){
            throw new DataStructException("当前栈中没有任何数据");
        }
        return arr[top--];
    }

    // 查看栈中的数据
    public long peek(){
        if (isEmpty()){
            throw new DataStructException("当前栈中没有任何数据");
        }
        return arr[top];
    }

    // 判断是否为空
    public boolean isEmpty(){
        return top == -1;
    }

    // 判断栈中是否满
    public boolean isFull(){
        return top == arr.length - 1;
    }
}

