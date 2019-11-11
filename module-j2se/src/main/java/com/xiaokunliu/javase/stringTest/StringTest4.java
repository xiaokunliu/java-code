package com.xiaokunliu.javase.stringTest;

/*
 * 4，模拟一个trim功能一致的方法
 * 1.使用两个变量，一个变量来记录前面的空格的下标
 * 				一个变量来记录后面的空格下标
 * 2，使用字符串的截取功能
 */
public class StringTest4 {

	private static final char SPACE=' ';
	public static void main(String[] args) {
		
		String key="      ab    c      ";
		key=myTrim2(key);
		System.out.println("="+key+"=");
	}

	public static String myTrim(String key) {
		int beginIndex = 0,endIndex=key.length()-1,len=key.length()-1;
		for (int i = 0; i <=len; i++) {
			if(SPACE!=key.charAt(i)){
				beginIndex=i;
				break;
			}
		}
		
		for (int i = len; i>=0; i--) {
			if(SPACE!=key.charAt(i)){
				endIndex=i;
				break;
			}
		}
		
		return key.substring(beginIndex, endIndex+1);
	}
	
	public static String myTrim2(String key) {
		int beginIndex = 0,endIndex=key.length()-1;
		
		while(beginIndex<endIndex && key.charAt(beginIndex)==SPACE)
			beginIndex++;
		
		while(beginIndex<endIndex && key.charAt(endIndex)==SPACE)
			endIndex--;
		
		return key.substring(beginIndex, endIndex+1);
	}
}
