package com.xiaokunliu.j2se.javase.ObjectAPITest;

import java.math.BigInteger;

public class BigIntegerDemo {

    public static void main(String[] args) {
//		BigInteger(String val)  将 BigInteger 的十进制字符串表示形式转换为 BigInteger。

        long max = Long.MAX_VALUE;
        System.out.println(max + 1);//数据溢出，返回long最小的值
        //long类型不够用
        BigInteger b1 = new BigInteger(max + "");
        BigInteger b2 = new BigInteger(2 + "");
        System.out.println("add-----------" + b1.add(b2));
        System.out.println("substract-----" + b1.subtract(b2));
        System.out.println("mutiply-------" + b1.multiply(b2));
        System.out.println("divide--------" + b1.divide(b2));

        //获得商和余数，
		/*
		 * 参数：
			val - 此 BigInteger 要除以的值和计算所得的余数。 
			返回：
			两个 BigInteger 的数组：商 (this / val) 是初始元素，余数 (this % val) 是最终元素。 
			抛出： 
			ArithmeticException - val==0
		 */
        BigInteger[] arr = b1.divideAndRemainder(b2);
        for (BigInteger bigInteger : arr) {
            System.out.println(bigInteger);
        }


    }
}
