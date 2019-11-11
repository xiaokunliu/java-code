package com.xiaokunliu.javase.ObjectAPITest;

import java.math.BigDecimal;

public class BigDecimalDemo {

	public static void main(String[] args) {
		
		double d1=2.00867687878;
		double d2=1.01;
		
//		doubleTest(d1, d2);
		
//		show_1(d1,d2);
		show_2(d1,d2);
		
	}

	public static void show_2(double d1, double d2) {
		//精准
		BigDecimal b1=new BigDecimal(d1+"");
		BigDecimal b2=new BigDecimal(d2+"");
		
		System.out.println("add:"+b1.add(b2));
		System.out.println("subtract:"+b1.subtract(b2));
		System.out.println("mutiply:"+b1.multiply(b2));
		/*
		 * 参数：
			divisor - 此 BigDecimal 要相除的值。 
			返回：
			this / divisor 
			抛出： 
			ArithmeticException - 如果准确的商值没有无穷的十进制扩展
		 */
//		System.out.println("divide:"+b1.divide(b2));//Non-terminating decimal expansion;no exact representable decimal result.
		try {
			System.out.println("divide:"+b1.divide(b2));
		} catch (ArithmeticException e) {
			
		}
	}

	public static void doubleTest(double d1, double d2) {
		System.out.println("add:"+(d1+d2));
		System.out.println("subtract:"+(d1-d2));
		System.out.println("mutiply:"+(d1*d2));
		System.out.println("divide:"+(d1/d2));
	}

	/*
	 * BigDecimal(double val) 将 double 转换为 BigDecimal，后者是 double 的二进制浮点值准确的十进制表示形式。---不精准
	 * 注： 
		此构造方法的结果有一定的不可预知性。有人可能认为在 Java 中写入 new BigDecimal(0.1) 所创建的 BigDecimal 正好等于 0.1
		（非标度值 1，其标度为 1），但是它实际上等于 0.1000000000000000055511151231257827021181583404541015625。
		这是因为 0.1 无法准确地表示为 double（或者说对于该情况，不能表示为任何有限长度的二进制小数）。
		这样，传入 到构造方法的值不会正好等于 0.1（虽然表面上等于该值）。 
		另一方面，String 构造方法是完全可预知的：
		写入 new BigDecimal("0.1") 将创建一个 BigDecimal，它正好 等于预期的 0.1。
		因此，比较而言，通常建议优先使用 String 构造方法。 
		当 double 必须用作 BigDecimal 的源时，请注意，此构造方法提供了一个准确转换；它不提供与以下操作相同的结果：
			先使用 Double.toString(double) 方法，然后使用 BigDecimal(String) 构造方法，
			将 double 转换为 String。要获取该结果，请使用 static valueOf(double) 方法。
			
		BigDecimal(String val)  将 BigDecimal 的字符串表示形式转换为 BigDecimal。---精准
	 */
	public static void show_1(double d1, double d2) {
		//不精准
		BigDecimal b1=new BigDecimal(d1);
		BigDecimal b2=new BigDecimal(d2);
		
		System.out.println("add:"+b1.add(b2));
		System.out.println("subtract:"+b1.subtract(b2));
		System.out.println("mutiply:"+b1.multiply(b2));
		/*
		 * 参数：
			divisor - 此 BigDecimal 要相除的值。 
			返回：
			this / divisor 
			抛出： 
			ArithmeticException - 如果准确的商值没有无穷的十进制扩展
		 */
//		System.out.println("divide:"+b1.divide(b2));//Non-terminating decimal expansion;no exact representable decimal result.
		try {
			System.out.println("divide:"+b1.divide(b2));
		} catch (ArithmeticException e) {
			
		}
		
	}
}
