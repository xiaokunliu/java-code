package com.xiaokunliu.javase.collection.list;

import java.util.LinkedList;

public class DuiLie<E> {

	private LinkedList<E> link;
	
	public DuiLie(){
		link=new LinkedList<E>();
	}
	
	public void add(E e){
		link.addFirst(e);
	}
	
	public E delete(){
		return link.removeLast();
	}
	
	public boolean isEmpty(){
		return link.isEmpty();
	}
	
	
	public int length(){
		return link.size();
	}
}
