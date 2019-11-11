package com.xiaokunliu.javase.net.tcp;

import java.io.*;
import java.net.Socket;

public class ClientDemo3 {

    public static void main(String[] args) throws IOException {
		//创建客户端对象，并且指定IP和端口
		Socket client=new Socket("localhost",10002);
		
		//建立socket流，并且获取socket的流对象
		OutputStream out=client.getOutputStream();
		String line=null;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while((line=br.readLine())!=null){
			//客户端向服务器端发送数据
			
			//写数据
			out.write(line.getBytes());
			
			//接收服务器的数据
			InputStream in=client.getInputStream();
			byte[] buf=new byte[1024];
			int len=0;
			len=in.read(buf);
			
			String reData=new String(buf,0,len);
			System.out.println("server-->send:"+reData);
			if("over".equals(line))
				break;
			
		}
		//关闭资源
		client.close();//out也已经关闭
	}
}
