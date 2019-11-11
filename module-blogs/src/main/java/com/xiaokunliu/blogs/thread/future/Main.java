package com.xiaokunliu.blogs.thread.future;

/**
 * Created by keithl on 2017/11/14.
 */

public class Main {

    public static void main(String[] args) {

        // 有一个Future的客户端
        FutureClient client = new FutureClient();

        // 客户端发起请求,异步请求,并响应回来
        System.out.println("客户端开始发送请求");
        FutureData futureData1 = client.getResponseText("i want tot user info1");
        FutureData futureData2 = client.getResponseText("i want tot user info2");

        // 发起请求的过程中不需要等待,继续执行其他的事情
        System.out.println("client 继续执行其他的事情start....");
        System.out.println("client 继续执行其他的事情中....");
        System.out.println("client 继续执行其他的事情end....");

        // 获取实际请求到的数据
        String result1 = futureData1.getResult();
        System.out.println(String.format("获取请求结果1[%s]", result1));

        String result2 = futureData2.getResult();
        System.out.println(String.format("获取请求结果2[%s]", result2));
    }
}
