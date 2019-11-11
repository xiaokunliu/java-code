package com.xiaokunliu.javase.ObjectAPITest;

import java.text.NumberFormat;
import java.util.Locale;

public class NmuberFormatTest {

    public static void main(String[] args) {
		
		double number=90.3783178;
		testDiffFormat(number);	
		
	}

	public static void testDiffFormat(double number) {
		//		static NumberFormat getCurrencyInstance() 
		//        返回当前默认语言环境的货币格式。 
				NumberFormat format=NumberFormat.getCurrencyInstance();
				String str=format.format(number);
				System.out.println("默认语言环境的货币格式--->"+str);
				System.out.println("=======================");
		//		static NumberFormat getCurrencyInstance(Locale inLocale) 
		//        		返回指定语言环境的货币格式。 
				format=NumberFormat.getCurrencyInstance(Locale.US);
				str=format.format(number);
				System.out.println("指定语言环境的货币格式--->"+str);
				System.out.println("=======================");
				//static NumberFormat getInstance() 
				//        返回当前默认语言环境的通用数字格式。 
				format=NumberFormat.getInstance();
				str=format.format(number);
				System.out.println("默认语言环境的通用数字格式--->"+str);
				System.out.println("=======================");
				
				//static NumberFormat getInstance(Locale inLocale) 
				//        返回指定语言环境的通用数字格式。 
				format=NumberFormat.getInstance(Locale.US);
				str=format.format(number);
				System.out.println("指定语言环境的通用数字格式--->"+str);
				System.out.println("=======================");
				//static NumberFormat getIntegerInstance() 
				//        返回当前默认语言环境的整数格式。 
				format=NumberFormat.getIntegerInstance();
				str=format.format(number);
				System.out.println("默认语言环境的整数格式--->"+str);
				System.out.println("=======================");
				
				//static NumberFormat getIntegerInstance(Locale inLocale)  
					//返回指定语言环境的整数格式。
				format=NumberFormat.getIntegerInstance(Locale.US);
				str=format.format(number);
				System.out.println("指定语言环境的整数格式--->"+str);
				System.out.println("=======================");
				
				//		static NumberFormat getNumberInstance() 
				//        返回当前默认语言环境的通用数字格式。 
				format=NumberFormat.getNumberInstance();
				str=format.format(number);
				System.out.println("默认语言环境的通用数字格式。--->"+str);
				System.out.println("=======================");
				
				
				//static NumberFormat getNumberInstance(Locale inLocale) 
				//        返回指定语言环境的通用数字格式。 
				format=NumberFormat.getNumberInstance(Locale.US);
				str=format.format(number);
				System.out.println("指定语言环境的通用数字格式--->"+str);
				System.out.println("=======================");
				
				//static NumberFormat getPercentInstance() 
				//        返回当前默认语言环境的百分比格式。 
				format=NumberFormat.getPercentInstance();
				str=format.format(number);
				System.out.println("默认语言环境的百分比格式。--->"+str);
				System.out.println("=======================");
				
				
				//static NumberFormat getPercentInstance(Locale inLocale) 
				//        返回指定语言环境的百分比格式。 
				format=NumberFormat.getNumberInstance(Locale.US);
				str=format.format(number);
				System.out.println("指定语言环境的百分比格式--->"+str);
				System.out.println("=======================");
	}
}
