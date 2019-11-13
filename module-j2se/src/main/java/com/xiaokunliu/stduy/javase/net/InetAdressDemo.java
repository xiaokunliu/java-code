package com.xiaokunliu.stduy.javase.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAdressDemo {

    /**
     * @param args
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException {


        InetAddress ip = InetAddress.getLocalHost();
        String hostAdd = ip.getHostAddress();
        String hostName = ip.getHostName();
        System.out.println(hostAdd + ":" + hostName);

        InetAddress ip2 = InetAddress.getByName("localhost");
        String hostAdd2 = ip2.getHostAddress();
        String hostName2 = ip2.getHostName();
        System.out.println(hostAdd2 + ":" + hostName2);


    }

}
