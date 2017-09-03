package com.dtrees.javase.net.tcp;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//应该建立多个客户端
		Client client=new Client(new Socket("localhost",10002));
		
		new Thread(client).start();
		
	}
}
