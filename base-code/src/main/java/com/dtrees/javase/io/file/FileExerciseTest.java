package com.dtrees.javase.io.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileExerciseTest {

	/*
	 * 获取指定目录下，指定扩展名的文件(包含子目录中的)
	 * 这些文件的绝对路径写入到一个文本文件中。
	 * 
	 * 简单说，就是建立一个指定扩展名的文件的列表。 
	 * 
	 * 思路：
	 * 1，必须进行深度遍历。
	 * 2，要在遍历的过程中进行过滤。将符合条件的内容都存储到容器中。
	 * 3，对容器中的内容进行遍历并将绝对路径写入到文件中。 
	 */
	
	public static void main(String[] args) throws IOException {
		
		
		File dir=new File("E:\\study\\itcastSE_Note\\Code");
		List<File> list=new ArrayList<File>();
		
		getFileList(dir,list,new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		});
		
//		for (File file : list) {
//			System.out.println(file.getAbsolutePath());
//		}
		OutputStreamWriter osw=new OutputStreamWriter(new 
				FileOutputStream(new File(".//src//com//wind//io//file//filelist.txt")));
		
		writeToFile(osw,list);
	}


	public static void writeToFile(OutputStreamWriter osw, List<File> list) {
		
		PrintWriter pw=new PrintWriter(osw,true);
		for (File file : list) {
			pw.println(file.getAbsolutePath());
		}
		pw.close();
	}


	public static void getFileList(File dir, List<File> list,FilenameFilter filter) {
		
		File[] files=dir.listFiles();
		for (File file : files) {
			if(file.isDirectory()){
				getFileList(file, list, filter);
			}else if(filter.accept(dir, file.getName())){
				list.add(file);
			}
		}
		
	}
}
