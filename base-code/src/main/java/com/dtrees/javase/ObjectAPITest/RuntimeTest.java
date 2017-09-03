package com.dtrees.javase.ObjectAPITest;

import java.io.IOException;

public class RuntimeTest {

	private final static Runtime run=Runtime.getRuntime();
	public static void main(String[] args) throws Exception{
		/*
		 * Runtime:没有构造方法摘要，说明该类不可以创建对象。
		 * 又发现还有非静态的方法。说明该类应该提供静态的返回该类对象的方法。
		 * 而且只有一个，说明Runtime类使用了单例设计模式。
		 */
//		testSystemMemory();
		
//			openApp();
		
		
	}
	public static void openApp() throws IOException {
		//		 Process exec(String command) 在单独的进程中执行指定的字符串命令。 
		run.exec("D:\\application\\KuGou\\KGMusic\\KuGou.exe");
	}
	public static void testSystemMemory() {
		//		 long freeMemory() 返回 Java 虚拟机中的空闲内存量。 
				long restMemory=run.freeMemory();
				System.out.println("restMemory---"+restMemory);
				
		//		long maxMemory()  返回 Java 虚拟机试图使用的最大内存量。 
				long maxMemory=run.maxMemory();
				System.out.println("maxMemory---"+maxMemory);
				
		//		long totalMemory()  返回 Java 虚拟机中的内存总量。 
				long totalMemory=run.totalMemory();
				System.out.println("totalMemory---"+totalMemory);
	}
}
