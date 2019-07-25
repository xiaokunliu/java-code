package com.xiaokunliu.thread.design.future;


public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		FutureClient fc = new FutureClient();
		Data data = fc.request("请求参数");
		System.out.println("请求发送成功!");
		System.out.println("做其他的事情...");
		
		String result = data.getRequest();	// 数据还没有处理好的时候就会一直处于阻塞状态
		System.out.println(result);
		
	}
}
