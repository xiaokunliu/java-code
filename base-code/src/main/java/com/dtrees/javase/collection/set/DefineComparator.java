package com.dtrees.javase.collection.set;

import com.dtrees.javase.bean.Person;

import java.util.Comparator;

public class DefineComparator implements Comparator<Person>{

	@Override
	public int compare(Person p1, Person p2) {
		int temp=p1.getName().compareTo(p2.getName());
		return temp==0?p1.getAge()-p2.getAge():temp;
	}

}
