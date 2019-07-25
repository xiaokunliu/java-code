package com.xiaokunliu.javase.io.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class CodeTest {

	public static void main(String[] args) throws IOException {
		
		//此时文件是UTF-8形式的编码
//		demo_1();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("D:\\utf_8.txt")));
//		BufferedReader br=new BufferedReader(new FileReader("D:\\gbk.txt"));
		
		String line=br.readLine();
		
		BufferedWriter osw=new BufferedWriter(new OutputStreamWriter(System.out));
		osw.write(line);
		osw.flush();
		
		osw.close();
		br.close();
		
		
	}

	public static void demo_1() throws UnsupportedEncodingException,
			IOException {
		//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				
				BufferedWriter osw=new BufferedWriter(new OutputStreamWriter(System.out,"UTF-8"));
				
				/*
				 * Java默认码表是Unicode，但是字符串默认的码表是本地操作系统平台默认的码表
				 */
		//		String line=br.readLine();
				osw.write(new String("中文".getBytes()));
				osw.flush();
	}
}
