package com.dtrees.study.datastruct.ch05;


public class FirstLastLinkList {

	private Node first;

	private Node last;
	
	public FirstLastLinkList() {
		first = null;
		last = null;
	}
	

	public void insertFirst(long value) {
		Node node = new Node(value);
		if(isEmpty()) {
			last = node;
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
		}
		last = node;
	}

	public Node deleteFirst() {
		Node tmp = first;
		if(first.next == null) {
			last = null;
		}
		first = tmp.next;
		return tmp;
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
		Node previous = first;
		while(current.data != value) {
			if(current.next == null) {
				return null;
			}
			previous = current;
			current = current.next;
		}
		
		if(current == first) {
			first = first.next;
		} else {
			previous.next = current.next;
		}
		return current;
		
	}

	public boolean isEmpty() {
		return (first == null);
	}
}
