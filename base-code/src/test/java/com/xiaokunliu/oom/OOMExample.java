package com.xiaokunliu.oom;

/**
 * Created by keithl on 2017/11/2.
 * OOM 例子
 */
public class OOMExample {

//    @Override
//    public String toString() {
//        // 栈溢出, java.lang.StackOverflowError
//        return this.toString();
//    }

    public static void main(String[] args) {
//        OOMExample oomExample = new OOMExample();
//        System.out.println(oomExample);
        /**
         *  堆溢出的场景:
         *
         */
        // java.lang.OutOfMemoryError: Requested array size exceeds VM limit,分配数组的大小超过JVM内存的设置
//        OOMExample[] oomExamples = new OOMExample[Integer.MAX_VALUE];
//        System.out.println(oomExamples);

        // 设置堆内存最大为1M,-Xmx1m
        for (int i=0;i<Integer.MAX_VALUE;i++){
            OOMExample oomExample = new OOMExample();
            System.out.println(String.format("第[%d]个OOM Example is %s",i,oomExample.toString()));
        }
    }
}
