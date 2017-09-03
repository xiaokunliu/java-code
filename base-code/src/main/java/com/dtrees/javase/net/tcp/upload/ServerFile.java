package com.dtrees.javase.net.tcp.upload;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {

	/*
	 * 接收客户端上传的文件，并且存储在服务端
	 */
	public static void main(String[] args) throws IOException {
		
		ServerSocket server=new ServerSocket(9999);
		System.out.println("服务器启动......");
		//获取连接到服务器的客户端对象
		Socket client=server.accept();
		System.out.println(client.getInetAddress().getHostAddress()+"connect.....");
		//接收从客户端的数据
		BufferedReader brIn=new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		//将数据写到服务器端的源设备中
		BufferedWriter bw=new BufferedWriter(new FileWriter("d:\\server.txt"));
		
		String line=null;
		while((line=brIn.readLine())!=null){
//			如果客户端没有通知服务器上传文件结束，则line=brIn.readLine()将处于阻塞状态，同时如果没有刷新缓冲区的数据，
//			当缓冲区的数据达到8kb时就会自动刷新一次，不过在实际开发中必须刷新缓冲区，否则会出现将数据接收存放在缓冲区中无法
//			写到目的源中
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		
		//接收客户端文件成功，向客户端发送消息
		PrintWriter pw=new PrintWriter(client.getOutputStream(),true);
		pw.println("接收文件成功！！！");
		
		bw.close();
		client.close();
		server.close();
	}
	
}
