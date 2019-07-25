package com.xiaokunliu.javase.net.tcp.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerImage {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server=new ServerSocket(10099);
		System.out.println("服务器启动......");
		Socket client=server.accept();
		String ip=client.getInetAddress().getHostAddress();
		System.out.println(ip+"connected.......");
		int count=0;
		//读取客户端发送过来的数据
		InputStream in=client.getInputStream();
		//存储到硬盘上
//		File file=new File("E:\\study\\itcastSE_Note\\day15\\image\\01.png");
		File dir=new File("E:\\study\\itcastSE_Note\\day15\\image\\server");
		if(!dir.exists()){
			dir.mkdirs();
		}
		File file=new File(dir, "server.bmp");
		while(file.exists()){
			file=new File(dir, "server("+(count++)+").bmp");
		}
		
		FileOutputStream fos=new FileOutputStream(file);

		byte[] buf=new byte[1024];
		int len=-1;
		while((len=in.read(buf))!=-1){
			fos.write(buf, 0, len);
		}
		
		//向客户端发送响应
		OutputStream out=client.getOutputStream();
		out.write("接收成功！！".getBytes());
		
		
		fos.close();
		client.close();
		server.close();
	}
}
