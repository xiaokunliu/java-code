package com.dtrees.javase.ObjectAPITest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) throws ParseException {
		
//		timeToDate();
		
//		dateFormat();
//		parseDate();
		
		String date1="2013-4-19";
		String date2="2013-4-30";
		
		getDay(date1,date2);
	}

	public static void getDay(String date1, String date2) throws ParseException{
		
		//将字符串转换为日期对象，使用日期格式器
		DateFormat dateFormat=DateFormat.getDateInstance();
		//两个方法一样
//		dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		
		Date d1=dateFormat.parse(date1);
		Date d2=dateFormat.parse(date2);
		
		
		long time=Math.abs(d1.getTime()-d2.getTime());
		int day=getDayFromTime(time);
		System.out.println(day);
		
	}

	public static int getDayFromTime(long time) {
		
		return (int)(time/1000/60/60/24);
	}

	/*
	 *  将日期格式的字符串-->日期对象。
	 * 	使用的是DateFormat类中的parse()方法。
	 */
	public static void parseDate() throws ParseException {
		//按照指定风格解析日期
		String str_date = "2012年4月19日";		
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
		Date date = dateFormat.parse(str_date);
		System.out.println(date);//Thu Apr 19 00:00:00 CST 2012
		
		//自定义风格解析日期
		str_date = "2011---8---17";
		dateFormat = new SimpleDateFormat("yyyy---MM---dd");
		date = dateFormat.parse(str_date);
		System.out.println(date);//Wed Aug 17 00:00:00 CST 2011
	}

	/*
	 * 对日期对象进行格式化。
	 * 将日期对象-->日期格式的字符串。
	 * 使用的是DateFormat类中的format方法。
	 */
	public static void dateFormat() {
		Date date=new Date();
		//获取相应的日期默认风格
		DateFormat dateFormat=DateFormat.getDateInstance();//不包含具体时间，只包含年月日,
		String str_date=dateFormat.format(date);
		System.out.println(str_date);//2014-2-3
		
		dateFormat=DateFormat.getDateTimeInstance();//包含具体时间
		str_date=dateFormat.format(date);
		System.out.println(str_date);//2014-2-3 9:42:51
		
		//使用其他风格,FULL
//		dateFormat=DateFormat.getDateInstance(DateFormat.FULL);//包含具体时间
		dateFormat=DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);//包含具体时间
		str_date=dateFormat.format(date);
		System.out.println(str_date);//2014年2月3日 星期一/2014年2月3日 星期一 上午09时48分50秒 CST
		
		//使用其他风格,LONG
//		dateFormat=DateFormat.getDateInstance(DateFormat.LONG);//包含具体时间
		dateFormat=DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);//包含具体时间
		str_date=dateFormat.format(date);
		System.out.println(str_date);//2014年2月3日/2014年2月3日 上午09时48分50秒
		
		//使用其他风格,MEDIUM(默认风格)
//		dateFormat=DateFormat.getDateInstance(DateFormat.MEDIUM);//包含具体时间
		dateFormat=DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);//包含具体时间
		str_date=dateFormat.format(date);
		System.out.println(str_date);//2014-2-3/2014-2-3 9:48:50
		
		//使用其他风格,SHORT
//		dateFormat=DateFormat.getDateInstance(DateFormat.SHORT);//包含具体时间
		dateFormat=DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);//包含具体时间
		str_date=dateFormat.format(date);
		System.out.println(str_date);//14-2-3/14-2-3 上午9:48
		
		
		//自定义风格
		dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");//2014-02-03 09:56:35 上午
//		dateFormat=new SimpleDateFormat("yyyy-MM-dd K:mm:ss a");//2014-02-03 9:55:44 上午
		str_date=dateFormat.format(date);
		System.out.println(str_date);
	}

	/*
	 * 日期对象和毫秒值之间的转换。
	 * 
	 * 毫秒值-->日期对象 ： 
	 * 	1，通过Date对象的构造方法  new Date(timeMillis);
	 *  2，还可以通过setTime设置。 
	 *  因为可以通过Date对象的方法对该日期中的各个字段(年月日等)进行操作。
	 *  
	 * 日期对象-->毫秒值：
	 * 	2，getTime方法。
	 * 因为可以通过具体的数值进行运算。 
	 */
	public static void timeToDate() {
		//根据毫秒来创建创建日期对象
//		long l=System.currentTimeMillis();
//		System.out.println();
		Date date=new Date(1391391377150l);
		System.out.println(date.toString());//Mon Feb 03 09:34:11 CST 2014
		
		Date date2=new Date();
		System.out.println(date2.toString());
		
		//根据日期获取毫秒数
		long l1=date.getTime();
		long l2=date2.getTime();
		System.out.println(l1);
		System.out.println(l2);
	}
}
