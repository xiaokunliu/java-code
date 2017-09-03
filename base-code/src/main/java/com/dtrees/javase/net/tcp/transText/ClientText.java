package com.dtrees.javase.net.tcp.transText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientText {

	/**
	 * 
	 * @param args
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		
		Socket client=new Socket("localhost",8888);
		
		//从客户端的控制台接收数据,由于是纯文本数据，因而使用字符流---源
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//将数据发送到服务器端----目的
		PrintWriter out=new PrintWriter(client.getOutputStream(),true);//自动刷新缓冲区的数据
		//读取从服务发送过来的数据
		BufferedReader brIn=new BufferedReader(new InputStreamReader(client.getInputStream()));
		String line=null;
		
		while((line=br.readLine())!=null){
			
			if("over".equals(line))
				break;
			//将数据发送到服务器端
			out.println(line);
			System.out.println(brIn.readLine());//注意readLine方法必须读取到换行符才能够获取，否则将处于阻塞状态
		}
		
		br.close();
		client.close();
	}
}
