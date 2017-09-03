package com.dtrees.javase.io.encode;

import java.io.IOException;

public class LianTong {


	/**
	 * @param args
	 * @throws IOException 
	 */

	
	public static void main(String[] args) throws IOException {
		
		String str = "联通";
		/*
		 * 此时UTF-8将按照两个字节进行读取，可以查看UTF-8编码表
		 * 在DataInputStream或者DataOutputStream中的readUTF或者writeUTF中查看UTF-8编码表的规则
		 * 以最低位的开始，为0开头按照一个字节读取，110和10开头将按照两个字节读取，1110,10,10按照三个字节读取
				11000001
				10101010
				11001101
				10101000
		*/
		byte[] buf = str.getBytes("gbk");
		
		for(byte b :buf){
			System.out.println(Integer.toBinaryString(b&255));
		}
	}
}
