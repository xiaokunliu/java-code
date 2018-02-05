package com.dtrees.datastruct.list.array;

/**
 * Created by keithl on 17-5-18.
 */
public class ArrayStruct {


    // 数组面向对象设计, java内置有数组ArrayList,参考Java的API之List
    public static void main(String[] args) {
        OrderArrayObject orderArrayObject = new OrderArrayObject();
        orderArrayObject.insert(12);
        orderArrayObject.insert(1);
        orderArrayObject.insert(5);
        orderArrayObject.insert(7);
        orderArrayObject.insert(9);
        orderArrayObject.insert(8);

        orderArrayObject.display();

        int index = orderArrayObject.search(9);
        System.out.println(index);
    }
}
