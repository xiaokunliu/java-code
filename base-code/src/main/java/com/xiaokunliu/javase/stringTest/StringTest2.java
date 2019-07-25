package com.xiaokunliu.javase.stringTest;

/*
 * 2，一个子串在整串中出现的次数。
 * "nbaernbatynbauinbaopnba"
 * 思路：
 * 1.定义一个变量用于记录字串出现的字数
 * 	以及一个变量来记录每次搜索到符合字串后面位置
 * 2.每一次搜索到的匹配的字串时就用计数器记录下来
 * 3.然后继续从该匹配的字串之后继续向下搜索，直至返回-1，即没有找到为止使用indexOf来获取
 */
public class StringTest2 {

	public static void main(String[] args) {
		
		String str="nbaernbatynbauinbaopnba";
		String key="nba";
		int count=getKeyCount_2(str,key);
		System.out.println("count:"+count);
	}

	public static int getKeyCount_2(String str, String key) {
		int count=0;
		int fromIndex=0;
		
		while((fromIndex=str.indexOf(key, fromIndex))!=-1){
			fromIndex=fromIndex+key.length();
			count++;
		}
		return count;
	}

	public static int getKeyCount(String str, String key) {
		
		int count=0;
//		int fromIndex=0;
		int index=0;
		while((index=str.indexOf(key))!=-1){
			
			str=str.substring(index+key.length());
			count++;
		}
		return count;
	}
	
	/**
	 * 获取子串在整串中出现的次数。
	 * @param str
	 * @param key
	 * @return
	 */
	public static int getKeyStringCount(String str, String key) {
		
		//1,定义计数器。 
		int count = 0;
		
		//2，定义变量记录key出现的位置。
		int index = 0;
		
		while((index = str.indexOf(key))!=-1){
			
			str = str.substring(index+key.length());
			count++;
		}
		return count;
	}
	
	public static int getKeyStringCount_2(String str, String key) {
		
		int count = 0;
		int index = 0;
		
		while((index = str.indexOf(key,index))!=-1){
			
			index = index + key.length();
			count++;
			
		}
		
		return count;
	}
}
