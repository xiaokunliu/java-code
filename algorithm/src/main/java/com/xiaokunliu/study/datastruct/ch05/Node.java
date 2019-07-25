package com.xiaokunliu.study.datastruct.ch05;

public class Node {

	public long data;

	public Node next;
	public Node previous;
	
	public Node(long value) {
		this.data = value;
	}
	

	public void display() {
		System.out.print(data + " ");
	}
}
