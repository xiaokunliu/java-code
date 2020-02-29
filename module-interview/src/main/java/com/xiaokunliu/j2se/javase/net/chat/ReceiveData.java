package com.xiaokunliu.j2se.javase.net.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveData implements Runnable {

    private DatagramSocket ds;

    public ReceiveData(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try {

            while (true) {
                //建立字节数组
                byte[] buf = new byte[1024];

                //建立接收数据的数据包，以解析发送端发送过来的数据
                DatagramPacket dp = new DatagramPacket(buf, buf.length);

                //接收数据
                ds.receive(dp);//该方法将会处于阻塞状态，建议先启动接收端，实际上，先启动接收或者发送端均是可以的，因为UDP是面向无连接

//				String hostAdd=dp.getAddress().getHostAddress();
                String hostName = dp.getAddress().getHostName();

                String data = new String(dp.getData(), 0, dp.getLength());
                System.out.println("RE:" + hostName + "---->" + data);
                if ("over".equals(data))
                    System.out.println("RE:" + hostName + "---->退出聊天" + data);
                break;
            }
        } catch (IOException e) {

        }
    }

}
