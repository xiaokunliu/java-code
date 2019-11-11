package com.xiaokunliu.javase.io.sequence;

import java.io.*;
import java.util.*;

public class SequenceInputStreamTest {

	public static void main(String[] args) throws IOException {
		
		/*
		 * 需求：将1.txt 2.txt 3.txt文件中的数据合并到一个文件中。
		 * 构造方法摘要 
			SequenceInputStream(Enumeration<? extends InputStream> e) 
          		通过记住参数来初始化新创建的 SequenceInputStream，该参数必须是生成运行时类型为 InputStream 
          		对象的 Enumeration 型参数。 
			SequenceInputStream(InputStream s1, InputStream s2) 
          		通过记住这两个参数来初始化新创建的 SequenceInputStream（将按顺序读取这两个参数，先读取 s1，然后读取 s2），
          		以提供从此 SequenceInputStream 读取的字节。 
          	Enumeration---vector
		 */
//		demo_1();
		
		demo_2();
	}

    public static void demo_2() throws IOException {
		//使用ArrayList
		List<FileInputStream> list=new ArrayList<FileInputStream>();
		list.add(new FileInputStream(".//src//com//wind//io//sequence//1.txt"));
		list.add(new FileInputStream(".//src//com//wind//io//sequence//2.txt"));
		list.add(new FileInputStream(".//src//com//wind//io//sequence//3.txt"));
		
		final Iterator<FileInputStream> it=list.iterator();
		
		/*
		 * 使用自定义的enumeration来实现相应的功能
		 */
		Enumeration<FileInputStream> en=new Enumeration<FileInputStream>(){

			@Override
			public boolean hasMoreElements() {
				return it.hasNext();
			}

			@Override
			public FileInputStream nextElement() {
				return it.next();
			}
			
		};
		SequenceInputStream sis=new SequenceInputStream(en);
		//直接使用API生成enumeration
//		SequenceInputStream sis=new SequenceInputStream(Collections.enumeration(list));
		

		BufferedReader br=new BufferedReader(new InputStreamReader(sis));
		PrintWriter pw=new PrintWriter(new FileWriter(".//src//com//wind//io//sequence//123合并_2.txt"),true);
		String line=null;
		while((line=br.readLine())!=null){
			pw.println(line);
		}
		pw.close();
		br.close();
	}

    public static void demo_1() throws IOException {
		Vector<FileInputStream> ve=new Vector<FileInputStream>();
		ve.add(new FileInputStream(".//src//com//wind//io//sequence//1.txt"));
		ve.add(new FileInputStream(".//src//com//wind//io//sequence//2.txt"));
		ve.add(new FileInputStream(".//src//com//wind//io//sequence//3.txt"));
		
		/*
		 * public class SequenceInputStreamextends InputStream
		 */
		SequenceInputStream sis=new SequenceInputStream(ve.elements());
		
		BufferedReader br=new BufferedReader(new InputStreamReader(sis));
		
	/*	BufferedWriter bw=new BufferedWriter(new FileWriter(".//src//com//wind//io//sequence//123合并.txt"));
		String line=null;
		while((line=br.readLine())!=null){
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		bw.close();*/
		
		
		PrintWriter pw=new PrintWriter(new FileWriter(".//src//com//wind//io//sequence//123合并.txt"),true);
		String line=null;
		while((line=br.readLine())!=null){
			pw.println(line);
		}
		pw.close();
		br.close();
	}
}
