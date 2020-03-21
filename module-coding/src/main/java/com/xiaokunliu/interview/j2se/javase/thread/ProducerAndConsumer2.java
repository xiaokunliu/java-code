package com.xiaokunliu.interview.j2se.javase.thread;//package com.wind.thread;
///**
// * 多线程的多生产、多消费
// * 对前面的程序进行改进
// * @author wind
// *
// */
////共享资源
//class Resource{
//	private String pro_name;
//    private int pro_num;
//	private boolean flag;
//	
//	
//	public synchronized void set(String pro_name){
//		
//			while(this.flag){
//				//true表示已经生产一个产品，通知消费者可以获取
//				try {
//					this.wait();
//				} catch (InterruptedException e) {
//				}
//			}
//			
//			this.pro_name=pro_name;
//			this.pro_num++;
//			System.out.println(Thread.currentThread().getName()+" 生产  a roast duck........,name="+this.pro_name+",num="+this.pro_num);
//			this.flag=true;
//			this.notifyAll();
//	}
//	
//	public synchronized void get(){
//		
//		while(!this.flag)
//		{
//			//表明可以通知生产者进行生产
//			try {
//				this.wait();
//			} catch (InterruptedException e) {
//			}
//		}
//		System.out.println(Thread.currentThread().getName()+" 消费 a roast duck,name="+this.pro_name+",num="+this.pro_num);
//		this.flag=false;
//		如果仅仅唤醒一个的话，有可能出现是消费者，而不是生产者，会使得整个出现陷入阻塞状态
//		this.notifyAll();
//	}
//	
//	
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
//			r.set("烤鸭");
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
//			r.get();
//		}
//	}
//	
//}
//
//public class ProducerAndConsumer2{
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
