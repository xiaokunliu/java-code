package com.dtrees.javase.net.tcp.upload;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 接收客户端上传的大数据
 */
public class ServerData {

	public static void main(String[] args) throws IOException{
		
		ServerSocket server=new ServerSocket(9090);
		System.out.println("服务器启动.....");
		
		//接收多个连接到服务器的客户端
		while(true){
			
			Socket client=server.accept();
			new Thread(new ServerThread(client)).start();
		}
	}
}
