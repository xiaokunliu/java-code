package com.xiaokunliu.javase.io.file.splitAndmerge;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class FileMergeDemo {

	public static void main(String[] args) throws IOException {
		
		//指定目录
		File dir=new File("E:\\partFile2");
		
		mergeFile(dir);
	}

	public static void mergeFile(File dir) throws IOException {
		
		//先深度搜索配置文件
		File[] files=dir.listFiles(new MyFileFilter(".properties"));
		//如果文件不存在或者多个将无法合并
		if(files.length!=1)
			throw new DataException(dir+",该目录下没有properties扩展名的文件或者不唯一");
		
		//获取配置文件
		File file=files[0];
		//先读取配置文件
		Properties pro=new Properties();
		//将数据加载到配置文件对象中
		pro.load(new FileInputStream(file));
		//测试一下是否有数据
//		pro.list(System.out);
		
		
		//获得配置信息的数据
		/*
		 * 	filename=00.mp3
			count=12
		 */
		String filename=pro.getProperty("filename");
		int count=Integer.parseInt(pro.getProperty("count"));
		
		
		
		//这里还要判断实际的碎片个数与配置文件的个数是否相同
		File[] fs=dir.listFiles(new MyFileFilter(".part"));
		
		if((count-1)!=fs.length){
			throw new DataException("碎片文件不符合要求，个数不对!应该"+(count-1)+"个");
		}
		//合并数据
		List<FileInputStream> list=new ArrayList<FileInputStream>();
//		for (int i=0;i<fs.length;i++) {
////			list.add(new FileInputStream(new File(dir,i+".part")));//保证按照一定顺序的碎片文件读取
//			list.add(new FileInputStream(fs[i]));//这样也可以
//		}
//		
		for (File f : fs) {
			list.add(new FileInputStream(f));//
		}
		
		SequenceInputStream sis=new SequenceInputStream(Collections.enumeration(list));
		
		FileOutputStream fos=new FileOutputStream(new File(dir, filename));
		
		byte[] buf=new byte[1024];
		int len=0;
		while((len=sis.read(buf))!=-1){
			fos.write(buf, 0, len);
		}
		
		sis.close();
		fos.close();
		
	}
}
