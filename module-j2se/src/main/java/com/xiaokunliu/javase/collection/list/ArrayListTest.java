package com.xiaokunliu.javase.collection.list;

import com.xiaokunliu.javase.bean.Person;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		List<Person> list=new ArrayList<Person>();
		list.add(new Person("xiao2",16));
		list.add(new Person("xiao5",19));
		list.add(new Person("xiao4",18));
		list.add(new Person("xiao1",15));
		list.add(new Person("xiao3",17));
		list.add(new Person("xiao5",19));
		
		
		for (Person person : list) {
			System.out.println(person);
		}
		
//		System.out.println(list.get(5));//java.lang.IndexOutOfBoundsException,Index: 5, Size: 5
	}
}
