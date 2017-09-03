package com.dtrees.javase.net.tcp.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread implements Runnable {

	private Socket client;
	public ServerThread(Socket client){
		this.client=client;
	}
	
	@Override
	public void run() {
		FileOutputStream fos=null;
		try {
			//目的
			String pathName="E:\\study\\itcastSE_Note\\day15\\server";
			File dir=new File(pathName);
			if(!dir.exists()){
				dir.mkdirs();
			}
			File file=new File(dir,"server.bmp");
			int count=0;
			while(file.exists()){
				file=new File(dir,"server("+(count++)+").bmp");
			}
			fos=new FileOutputStream(file);
			//接收客户端上传的数据
			InputStream in=client.getInputStream();
			
			byte[] buf=new byte[1024];
			int len=0;
			while((len=in.read(buf))!=-1){
				fos.write(buf, 0, len);
			}
			
			
			//向客户端发送响应信息
			OutputStream out=client.getOutputStream();
			out.write("接收成功！！".getBytes());
		} catch (IOException e) {
			
			
		}finally{
			try {
				if(fos!=null){
					fos.close();
				}
				if(client!=null){
					client.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
