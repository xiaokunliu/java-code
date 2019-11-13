package com.xiaokunliu.stduy.javase.thread;//package com.wind.thread;
///**
// * 多线程的多生产、多消费
//使用wait、notifyAll
// * @author wind
// *
// */
////共享资源
//class Resource{
//	String pro_name;
//    int pro_num;
//	boolean flag;
//}
//
////生产区间----提交线程处理
//class Producer implements Runnable{
//
//	Resource r;
//	Producer(Resource r){
//		this.r=r;
//	}
//	@Override
//	public void run() {
//		while(true){
//			synchronized(r){
////				if(r.flag)
//				while(r.flag)
//					//true表示已经生产一个产品，通知消费者可以获取
//					try {
//						r.wait();
//					} catch (InterruptedException e) {
////						// TODO Auto-generated catch block
////						e.printStackTrace();
//					}
//				r.pro_name="烤鸭";
//				r.pro_num++;
//				System.out.println(Thread.currentThread().getName()+" 生产  a roast duck........,name="+r.pro_name+",num="+r.pro_num);
//				r.flag=true;
//				r.notifyAll();
//			}
//		}
//	}
//	
//}
//
////消费区间
//class Consumer implements Runnable{
//
//	Resource r;
//	Consumer(Resource r){
//		this.r=r;
//	}
//	@Override
//	public void run() {
//		while(true){
//			synchronized(r){
//				while(!r.flag)
////				if(!r.flag)
//					try {
//						r.wait();
//					} catch (InterruptedException e) {
//						// TODO: handle exception
//					}
//				System.out.println(Thread.currentThread().getName()+" 消费 a roast duck,name="+r.pro_name+",num="+r.pro_num);
////				r.pro_num--;
//				r.flag=false;
//				r.notifyAll();
//			}
//		}
//	}
//	
//}
//
//public class ProducerAndConsumer{
//
//	public static void main(String[] args) {
//		//建立资源
//		Resource r=new Resource();
//		//建立对资源进行管理的任务
//		Producer pro=new Producer(r);
//		Consumer con=new Consumer(r);
//		//创建线程来管理
//		Thread t0=new Thread(pro);
//		Thread t1=new Thread(pro);
//		Thread t2=new Thread(pro);
//		Thread t3=new Thread(pro);
//	
//		
//		Thread t4=new Thread(con);
//		Thread t5=new Thread(con);
//		
//		Thread t6=new Thread(con);
//		Thread t7=new Thread(con);
//		
//		t0.start();
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
//		t5.start();
//		t6.start();
//		t7.start();
//	}
//}
