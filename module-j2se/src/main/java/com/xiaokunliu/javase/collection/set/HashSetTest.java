package com.xiaokunliu.javase.collection.set;

import com.xiaokunliu.javase.bean.Person;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		
		/*
		 * 根据hashcode以及equals方法来进行比较，
		 * 如果hashcode相同，则进行equals方法的比较
		 */
		Set<Person> set=new HashSet<Person>();
		set.add(new Person("xiao1",1));
		set.add(new Person("xiao2",2));
		set.add(new Person("xiao3",3));
		set.add(new Person("xiao4",4));
		set.add(new Person("xiao5",5));
		set.add(new Person("xiao5",5));
		
		
		Iterator<Person> it=set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
