package com.xiaokunliu.javase.io.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest {

	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		FileWriter fw=new FileWriter("demo_copy.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		
		bw.write("晓第四季度叫我动物的口吻都殴打我到我的就");
		//必须将缓冲区的数据刷新到目的地
		bw.flush();
		bw.close();
		
	}
}
