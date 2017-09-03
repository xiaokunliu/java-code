package com.dtrees.javase.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPSendDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		//建立UDP的发送端
		System.out.println("UDP发送到启动......");
		DatagramSocket ds=new DatagramSocket();
		//准备数据
		String data="hello 到就看得见";
		byte[] buf=data.getBytes();
		
		//建立数据包,将数据封装在数据包中
		DatagramPacket dp=new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 10101);
		
		//发送数据
		ds.send(dp);
		
		//关闭资源
		ds.close();
		
		
	}

}
