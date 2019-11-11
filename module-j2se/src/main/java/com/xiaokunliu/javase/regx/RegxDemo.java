package com.xiaokunliu.javase.regx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegxDemo {

	public static void main(String[] args) {
		
//		String phone="13751772395";
//		boolean is=phoneIsMatch(phone);
//		System.out.println(phone+" "+is);

//		String str="xiaoqiang 	xiaoming 	kk ll ioioi 	ushdu";
		//将其中的字符串以重复字符作为分割点
//		String str="suzunnnnnnnnmeinvppppppppxiaoheiqqqqqqqxiaoqiangtttttttheidou";
//		strSplit(str);
		//将多个重复替换为1个
//		String str="suzunnnn@@@@nnnmeinvpp###ppppxiaoheiqqq&&&qqxiaoqiangttt！！！ttheidou";
//		strReplace(str);
		//获取该字符串中的只含三个单词的字符
		String str="jin tian tian qi hao liang shuang,dan shi bu shi xiu xi ri,zhen ke wu!";
		getSpecialKey(str);
		
	}
	
	
	public static void getSpecialKey(String str) {
		
		//使用正则表达式的对象
		//首先建立正则表达式		\\b表示单词的边界
		String regex="\\b\\w{3}\\b";
		Pattern p=Pattern.compile(regex);
		
		//将要进行匹配的数据存放在匹配器中
		Matcher matcher=p.matcher(str);
		
		//必须查找，才能获取
		while(matcher.find()){
			System.out.println(matcher.group());
		}
		
	}


	/*
	 * 正则表达式：
	 * 	3、替换
	 */
	public static void strReplace(String str) {
		/*
		 * ()称为一组，在替换的方法中，后面要使用前面的已经分组好的正则表达式用$
		 * $1表示第一组，$2表示第二组，以此类推
		 */
		str=str.replaceAll("(.)\\1+", "$1");
		System.out.println("str--->"+str);
		
		String ph="13751772395";
		ph=ph.replaceAll("(1[358]\\d{1})\\d{5}(\\d{3})", "$1*****$2");
		System.out.println(ph);
		
	}



	/*
	 * 正则表达式
	 * 	2、切割字符串
	 */
	public static void strSplit(String str) {
		
//		String regex=" +";//等价于\\s+,最好不用这样子表示
		String regex="(.)\\1+";//等价于\\s+
//		String regex="(\\w+)\\1+";//等价于\\s+-----仅仅对单词有效
		
		String[] arrs=str.split(regex);
		for(String s:arrs){
			System.out.println(s);
		}
	}



	/*
	 * 正则表达式
	 * 1、匹配字符串
	 */
	public static boolean phoneIsMatch(String phone) {
		
//		String regex="1[358][0-9]{9}";
		String regex="1[358]\\d{9}";
		
		return phone.matches(regex);
	}
}
