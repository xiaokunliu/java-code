package com.xiaokunliu.javase.io.reader;

import java.io.FileReader;
import java.io.IOException;
/*
 * 操作IO流必须记得关闭流，避免资源浪费
 */
public class FileReaderDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		FileReader fr=new FileReader("demo.txt");
		
//		demo_1(fr);
		demo_2(fr);
//		demo_3(fr);
		
		fr.close();
		
	}

	public static void demo_2(FileReader fr) throws IOException {
		//读取字符数组，返回是字符数组读取到的个数，规范写法
		char[] chs=new char[1024];
		int len=0;
		
		while((len=fr.read(chs))!=-1){
			//将读取到整个字符数据全部显示出来
//			System.out.println(new String(chs));
			//读取多少就显示多少
			System.out.print(new String(chs,0,len));
		}
	}

	public static void demo_3(FileReader fr) throws IOException {
		//读取字符数组，返回是字符数组读取到的个数，不规范写法
		char[] chs=new char[10];
		int len=0;
		
		while((len=fr.read(chs))!=-1){
			//将读取到整个字符数据全部显示出来
			System.out.println(new String(chs));
			//读取多少就显示多少
//			System.out.print(new String(chs,0,len));
		}
	}

	public static void demo_1(FileReader fr) throws IOException {
		//逐一读取字符，效率低
		/*
		 *  int read() 读取单个字符。 
		 *  返回是字符的ascii码对应的数据
		 */
		int ch=0;
		while((ch=fr.read())!=-1){
			System.out.print((char)ch+"");
		}
	}

}
