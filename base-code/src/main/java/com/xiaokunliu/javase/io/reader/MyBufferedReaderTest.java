package com.xiaokunliu.javase.io.reader;

import java.io.FileReader;
import java.io.IOException;

public class MyBufferedReaderTest {

	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		
		FileReader fd=new FileReader("demo.txt");
		
		demo_1(fd);
		
//		demo_2(fd);
		
	}


	public static void demo_2(FileReader fd) throws IOException {
		MyBufferedReader br=new MyBufferedReader(fd);
		
		
		String line=null;
		while((line=br.readLine())!=null){
			System.out.println(line);
		}
		
		
		br.close();
	}

	public static void demo_1(FileReader fd) throws IOException {
		MyBufferedReader br=new MyBufferedReader(fd);
		
		int ch=0;
		while((ch=br.read())!=-1){
			System.out.print((char)ch);
		}
		
		br.close();
	}
}
