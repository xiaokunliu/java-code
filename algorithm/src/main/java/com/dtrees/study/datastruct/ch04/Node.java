package com.dtrees.study.datastruct.ch04;

public class Node {

	public long data;

	public Node next;
	
	public Node(long value) {
		this.data = value;
	}
	

	public void display() {
		System.out.print(data + " ");
	}
}
