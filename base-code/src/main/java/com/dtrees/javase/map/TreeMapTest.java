package com.dtrees.javase.map;

import com.dtrees.javase.bean.Person;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
//		testTreeMap_1();
		
//		TreeMap<Person,String> map=new TreeMap<Person,String>(new DefineComparator());
		TreeMap<Person,String> map=new TreeMap<Person,String>();
		map.put(new Person("xiao1",1), "wind1");
		map.put(new Person("xiao5",5), "wind5");
		map.put(new Person("xiao5",5), "wind5");
		map.put(new Person("xiao2",2), "wind2");
		map.put(new Person("xiao4",4), "wind4");
		map.put(new Person("xiao3",3), "wind3");
		map.put(new Person("xiao3",3), "wind3");
		map.put(new Person("xiao6",6), "wind6");
		
		
		for(Map.Entry<Person, String> entry:map.entrySet()){
			System.out.println("key---"+entry.getKey()+":value----"+entry.getValue());
		}
	}

	public static void testTreeMap_1() {
		Map<Integer,Person> map=new TreeMap<Integer,Person>();
		map.put(1, new Person("xiao1",11));
		map.put(6, new Person("xiao6",16));
		map.put(2, new Person("xiao2",12));
		map.put(4, new Person("xiao4",14));
		map.put(5, new Person("xiao5",15));
		map.put(3, new Person("xiao3",13));
		
		
		for(Integer key:map.keySet()){
			System.out.println("key---"+key+":value----"+map.get(key));
		}
	}
}
