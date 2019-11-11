package com.xiaokunliu.javase.collection.list;

import com.xiaokunliu.javase.bean.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListTest {
	
	
	public static void main(String[] args) {

		List<Person> list=new ArrayList<Person>();
		list.add(new Person("xiao1",15));
		list.add(new Person("xiao2",16));
		list.add(new Person("xiao3",17));
		list.add(new Person("xiao4",18));
		list.add(new Person("xiao5",19));
		
		Iteraotr1(list);
		System.out.println(list);
//		listIterator(list);
//		System.out.println(list);
	}

	public static void listIterator(List<Person> list) {
		//修改list的集合元素
		ListIterator<Person> lin=list.listIterator();
		while(lin.hasNext()){
			Person p=lin.next();
			if(p.getAge()==19)
				lin.add(new Person("xiao378",32));//可以添加元素
//			ListIterator方法：
				//	 void add(E e) 
				//	          将指定的元素插入列表（可选操作）。 
				//	 boolean hasNext() 
				//	          以正向遍历列表时，如果列表迭代器有多个元素，则返回 true（换句话说，如果 next 返回一个元素而不是抛出异常，则返回 true）。 
				//	 boolean hasPrevious() 
				//	          如果以逆向遍历列表，列表迭代器有多个元素，则返回 true。 
				//	 E next() 
				//	          返回列表中的下一个元素。 
				//	 int nextIndex() 
				//	          返回对 next 的后续调用所返回元素的索引。 
				//	 E previous() 
				//	          返回列表中的前一个元素。 
				//	 int previousIndex() 
				//	          返回对 previous 的后续调用所返回元素的索引。 
				//	 void remove() 
				//	          从列表中移除由 next 或 previous 返回的最后一个元素（可选操作）。 
				//	 void set(E e) 
				//	          用指定元素替换 next 或 previous 返回的最后一个元素（可选操作）。 

		}
	}

	public static void Iteraotr1(List<Person> list) {
		Iterator<Person> it=list.iterator();
		
		while(it.hasNext()){
			Person p=it.next();
			if(p.getAge()==18)
				list.set(3, new Person("xiao8",20));//正常
//				list.add(new Person("xiao8",20));//java.util.ConcurrentModificationException抛出异常，说明此时无法添加
			//无法修改list的集合，若要修改必须使用ListIterator<E> listIterator() 返回此列表元素的列表迭代器（按适当顺序）。 
//	          ListIterator<E> listIterator(int index) 
//	                   返回列表中元素的列表迭代器（按适当顺序），从列表的指定位置开始。 

		}
	}
	
	
	
	
	
		//必须明确List是一个有角标的集合，下面是通过角标方法来访问，是List特有的方法
		//void add(int index, E element) 
		//    在列表的指定位置插入指定元素（可选操作）。 
		//boolean addAll(int index, Collection<? extends E> c) 
		//    将指定 collection 中的所有元素都插入到列表中的指定位置（可选操作）。 
		//E get(int index) 
		//    返回列表中指定位置的元素。 
		//int indexOf(Object o) 
		//    返回此列表中第一次出现的指定元素的索引；如果此列表不包含该元素，则返回 -1。 
		//Iterator<E> iterator() 
		//    返回按适当顺序在列表的元素上进行迭代的迭代器。 
		//int lastIndexOf(Object o) 
		//    返回此列表中最后出现的指定元素的索引；如果列表不包含此元素，则返回 -1。 
		//ListIterator<E> listIterator() 
		//    返回此列表元素的列表迭代器（按适当顺序）。 
		//ListIterator<E> listIterator(int index) 
		//    返回列表中元素的列表迭代器（按适当顺序），从列表的指定位置开始。 
		//E remove(int index) 
		//    移除列表中指定位置的元素（可选操作）。 
		//E set(int index, E element) 
		//    用指定元素替换列表中指定位置的元素（可选操作）。 
		//List<E> subList(int fromIndex, int toIndex) 
		//    返回列表中指定的 fromIndex（包括 ）和 toIndex（不包括）之间的部分视图。 

}
