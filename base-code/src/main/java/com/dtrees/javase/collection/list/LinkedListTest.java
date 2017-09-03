package com.dtrees.javase.collection.list;

import com.dtrees.javase.bean.Person;

/*
 * 请使用LinkedList来模拟一个堆栈或者队列数据结构。
 * 
 * 堆栈：先进后出 First In Last Out  FILO
 * 
 * 队列：先进先出 First In First Out FIFO
 * 
 * 我们应该描述这样一个容器，给使用提供一个容器对象完成这两种结构中的一种。
 */
public class LinkedListTest {

	public static void main(String[] args) {
		
//		DuiLie<Person> d=new DuiLie<Person>();
//		d.add(new Person("xiao1",1));
//		d.add(new Person("xiao2",2));
//		d.add(new Person("xiao3",3));
//		d.add(new Person("xiao4",4));
//		
//		System.out.println(d.delete());
//		System.out.println(d.delete());
//		System.out.println(d.delete());
//		System.out.println(d.delete());
		
		
		Zhan<Person> z=new Zhan<Person>();
		z.add(new Person("xiao1",1));
		z.add(new Person("xiao2",2));
		z.add(new Person("xiao3",3));
		z.add(new Person("xiao4",4));
		
		System.out.println(z.delete());
		System.out.println(z.delete());
		System.out.println(z.delete());
		System.out.println(z.delete());
	}
	
}
