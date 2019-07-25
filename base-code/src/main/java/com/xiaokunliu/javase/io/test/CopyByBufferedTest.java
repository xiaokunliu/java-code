package com.xiaokunliu.javase.io.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyByBufferedTest {

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new FileReader("demo.txt"));
		
		BufferedWriter bw=new BufferedWriter(new FileWriter("copy_demo.txt"));
		
		
//		demo_1(br, bw);
		
//		demo_2(br, bw);
		
		
		demo_3(br, bw);
		
	}

	public static void demo_3(BufferedReader br, BufferedWriter bw)
			throws IOException {
		String line=null;
		
		while((line=br.readLine())!=null){
			bw.write(line);
			//换行
			bw.newLine();
			bw.flush();
		}
		
		
		bw.close();
		br.close();
	}

	public static void demo_2(BufferedReader br, BufferedWriter bw)
			throws IOException {
		int len=0;
		char[] buf=new char[1024];
		while((len=br.read(buf))!=-1){
			bw.write(buf, 0, len);
			bw.flush();
		}

		bw.close();
		br.close();
	}

	public static void demo_1(BufferedReader br, BufferedWriter bw)
			throws IOException {
		int ch=0;
		while((ch=br.read())!=-1){
			bw.write((char)ch);
			bw.flush();
		}
		
		bw.close();
		br.close();
	}
}
