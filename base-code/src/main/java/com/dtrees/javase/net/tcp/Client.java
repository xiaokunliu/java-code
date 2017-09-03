package com.dtrees.javase.net.tcp;

/**
 * Created by keithl on 2017/9/3.
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client implements Runnable{

    private Socket client;
    public Client(Socket client){
        this.client=client;
    }
    @Override
    public void run() {
        try {
            //建立socket流，并且获取socket的流对象
            OutputStream out=client.getOutputStream();
            String line=null;
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            while((line=br.readLine())!=null){
                //客户端向服务器端发送数据

//				//写数据
//				out.write(Thread.currentThread().getName().getBytes());
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
        } catch (Exception e) {

        }
    }

}
