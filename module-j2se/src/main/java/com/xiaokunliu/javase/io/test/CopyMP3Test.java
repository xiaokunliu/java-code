package com.xiaokunliu.javase.io.test;

import java.io.*;
/*
 * 字节流一般用于拷贝媒体文件等，而媒体文件不用字符流来获取，因为在编码表上可能找不到媒体文件相应的二进制编码表示形式，这样
 * 将导致编码表上会使用一些不存在字符的编码形式添加上去，导致文件受损，文法正常使用时
 * 字符流只用于文字文本拷贝，因为要防止出现乱码
 */
public class CopyMP3Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		copy_1();
		
	}

//	千万不要用，效率没有！
	public static void copy_4() throws IOException {
		FileInputStream fis = new FileInputStream("D:\\KuGou\\Akon - Keep Up.mp3");		
		FileOutputStream fos = new FileOutputStream("c:\\4.mp3");
		
		
		int ch = 0;
		
		while((ch =fis.read())!=-1){
			fos.write(ch);
		}
		
		fos.close();
		fis.close();
	}

	//不建议。 
	public static void copy_3() throws IOException {
		FileInputStream fis = new FileInputStream("D:\\KuGou\\Akon - Keep Up.mp3");		
		FileOutputStream fos = new FileOutputStream("c:\\3.mp3");
		
		byte[] buf = new byte[fis.available()];
		fis.read(buf);
		fos.write(buf);
		fos.close();
		fis.close();
	}

	public static void copy_2() throws IOException {
		
		FileInputStream fis = new FileInputStream("D:\\KuGou\\Akon - Keep Up.mp3");	
		BufferedInputStream bufis = new BufferedInputStream(fis);
		
		FileOutputStream fos = new FileOutputStream("c:\\2.mp3");
		BufferedOutputStream bufos = new BufferedOutputStream(fos);
		
	
		
		int ch = 0;
		
		while((ch=bufis.read())!=-1){
			bufos.write(ch);
		}
		
		bufos.close();
		bufis.close();
	}

	public static void copy_1() throws IOException {
		
		FileInputStream fis = new FileInputStream("D:\\KuGou\\Akon - Keep Up.mp3");		
		FileOutputStream fos = new FileOutputStream("d:\\1.mp3");
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		
		while((len=fis.read(buf))!=-1){
			fos.write(buf,0,len);
		}
		
		fos.close();
		fis.close();
	}
}
