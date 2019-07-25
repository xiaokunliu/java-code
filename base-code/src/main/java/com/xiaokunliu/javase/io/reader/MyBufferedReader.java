package com.xiaokunliu.javase.io.reader;

import java.io.IOException;
import java.io.Reader;

/*
 * 装饰设计模式
 * 缓冲区的原理：
 * 1.read方法是使用底层的流读取对象来进行读取，首先需要将一个容器存放一些从底层读取到的数据，
 * 	 然后该read方法就从容器里面获取数据，并且指针向下走，缓冲区数据将减少一个
 * 
 */
public class MyBufferedReader extends Reader{

	private Reader in;
	//定义一个容器来存放从底层读取到的数据，然后直接从容器里面获取
	private char[] buf=new char[1024];
	//定义一个指针来追踪数据应从哪个位置开始读取,并且每次在计算器为0重新获取时将指针指向最初的位置
	private int pos;
	//定义一个计数器来计算缓冲区里面的数据有多少，如果count=0表示需要从缓冲区中获取数据，
	//如果获取数据返回-1则表示底层没有数据，已经全部将数据读取完
	private int count;
	
	
	public MyBufferedReader(Reader in){
		this.in=in;
	}
	
	@Override
	public int read() throws IOException{
		if(count==0){
			count=in.read(buf);
			pos=0;
		}
		if(count<0){
			return -1;
		}
		
		char ch=buf[pos++];
		count--;
		return ch;
		
	}
	
	
	public String readLine() throws IOException{
		StringBuilder sb=new StringBuilder();
		int ch=0;
		while((ch=read())!=-1){
			if(ch=='\r')
				continue;
			if(ch=='\n')
				return sb.toString();
			sb.append((char)ch);
		}
		if(sb.length()>0)
			return sb.toString();
		return null;
	}
	
	
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		
		
		
		return 0;
	}

	@Override
	public void close() throws IOException {
		if(in!=null){
			in.close();
		}
		
	}

}
