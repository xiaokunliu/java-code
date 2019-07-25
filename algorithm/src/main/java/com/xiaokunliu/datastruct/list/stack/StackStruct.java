package com.xiaokunliu.datastruct.list.stack;

/**
 * Created by keithl on 2017/10/29.
 */

public class StackStruct {

    public static void main(String[] args) {

        // 栈的测试
        StackObject stackObject = new StackObject();
        stackObject.push(9);
        stackObject.push(29);
        stackObject.push(39);
        stackObject.push(69);

        while (!stackObject.isEmpty()){
            System.out.println(stackObject.pop());
        }
    }
}
