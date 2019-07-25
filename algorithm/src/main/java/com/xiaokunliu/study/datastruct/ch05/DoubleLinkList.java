package com.xiaokunliu.study.datastruct.ch05;

// 双向链表
public class DoubleLinkList {

	private Node first;

	private Node last;
	
	public DoubleLinkList() {
		first = null;
		last = null;
	}
	

	public void insertFirst(long value) {
		Node node = new Node(value);
		if(isEmpty()) {
			last = node;
		} else {
			first.previous = node;
		}
		node.next = first;
		first = node;
	}
	

	public void insertLast(long value) {
		Node node = new Node(value);
		if(isEmpty()) {
			first = node;
		} else {
			last.next = node;
			node.previous = last;
		}
		last = node;
	}
	

	public Node deleteFirst() {
		Node tmp = first;
		if(first.next == null) {
			last = null;
		} else {
			first.next.previous = null;
		}
		first = tmp.next;
		return tmp;
	}
	

	public Node deleteLast() {
		Node tmp = last;
		if(first.next == null) {
			first = null;
		} else {
			last.previous.next = null;
		}
		last = last.previous;
		return last;
	}

	public void display() {
		Node current = first;
		while(current != null) {
			current.display();
			current = current.next;
		}
		System.out.println();
	}

	public Node find(long value) {
		Node current = first;
		while(current.data != value) {
			if(current.next == null) {
				return null;
			}
			current = current.next;
		}
		return current;
	}

	public Node delete(long value) {
		Node current = first;
		while(current.data != value) {
			if(current.next == null) {
				return null;
			}
			current = current.next;
		}
		
		if(current == first) {
			first = first.next;
		} else {
			current.previous.next = current.next;
		}
		return current;
		
	}

	public boolean isEmpty() {
		return (first == null);
	}
}
