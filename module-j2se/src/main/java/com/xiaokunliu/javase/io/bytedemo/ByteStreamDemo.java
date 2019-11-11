package com.xiaokunliu.javase.io.bytedemo;

import java.io.*;

public class ByteStreamDemo {

	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("demo.txt");
		BufferedInputStream bis=new BufferedInputStream(fis);
		
		FileOutputStream fos=new FileOutputStream("copy_byte_demo.txt");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		
		demo_3(bis, bos);
		
		
//		demo_4(bis, bos);
//		demo_1(fis, fos);
		
//		demo_2(fis, fos);

		
	}

	//不建议用，当文件过大则会发生内存溢出
	public static void demo_3(BufferedInputStream bis, BufferedOutputStream bos)
			throws IOException {
		//bis.available()获取文件大小，即有多少个字节
		byte[] buf=new byte[bis.available()];
		//此时无需循环
		bis.read(buf);
		bos.write(buf);
		
		bis.close();
		bos.close();
	}

//	一般使用这个
	public static void demo_4(BufferedInputStream bis, BufferedOutputStream bos)
			throws IOException {
		byte[] buf=new byte[1024];
		int len=0;
		while((len=bis.read(buf))!=-1){
			bos.write(buf, 0, len);
			//缓冲区必须刷
			bos.flush();
		}
		
		
		bis.close();
		bos.close();
	}
	
//	一般使用这个
	public static void demo_2(FileInputStream fis, FileOutputStream fos)
			throws IOException {
		int len=0;
		byte[] buf=new byte[1024];
		while((len=fis.read(buf))!=-1){
			
			fos.write(buf, 0, len);
		}
		
		close(fis, fos);
	}

	public static void demo_1(FileInputStream fis, FileOutputStream fos)
			throws IOException {
		int bs=0;
		
		while((bs=fis.read())!=-1){
			//字节流在获取数据无需查看表对应来显示数据，这里无需缓冲，可以不用刷新
			//字符流是通过字节流获取数据然后根据指定的表来进行编码，这里需要缓冲，因而需要将数据刷新到目的地
			fos.write(bs);
			//无需刷新
		}
		
		//最后必须关闭资源
		close(fis, fos);
	}

	public static void close(FileInputStream fis, FileOutputStream fos)
			throws IOException {
		fos.close();
		fis.close();
	}
}
