package com.xiaokunliu.j2se.javase.reflect;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodDemo {

//	public void getMyStance(int len,String[] strArr){
//		System.out.println("getMyStance len is "+len+",strArr is "+Arrays.asList(strArr));
//	}
//	
//	
//	public void getMyStance2(Object len,Object[] strArr){
//		System.out.println("getMyStance2 len is "+len+",strArr is "+Arrays.asList(strArr));
//	}

    public static void main(String[] args) throws Exception {

        Method method = MethodDemo.class.getMethod("print", String[].class);
        MethodDemo obj = new MethodDemo();

//		int len = 9;

        /*
         * 执行此处的时候将抛出异常：
         * 	rong number of arguments
         */
//		method.invoke(obj,new String[]{"haha","xiao"});

        /*
         * 根本原因是jdk1.5需要往下兼容jdk1.4版本，jdk1.4版本传递的参数是一个数组类型的Class对象
         * 解决方法一
         */
//		method.invoke(obj,(Object)new String[]{"haha","xiao"});
        /*
         * 解决方法二
         */
        method.invoke(obj, new Object[]{new String[]{"haha", "xiao"}});

    }

    public void print(String[] strArr) {
        System.out.println(Arrays.asList(strArr));
    }
}
