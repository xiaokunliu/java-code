package com.xiaokunliu.study.datastruct.ch17;

public class LinkList {

	private Node first;
	
	public LinkList() {
		first = null;
	}
	

	public void insertFirst(Info info) {
		Node node = new Node(info);
		node.next = first;
		first = node;
	}
	

	public Node deleteFirst() {
		Node tmp = first;
		first = tmp.next;
		return tmp;
	}
	
	

	public Node find(String key) {
		Node current = first;
		while(!key.equals(current.info.getKey())) {
			if(current.next == null) {
				return null;
			}
			current = current.next;
		}
		return current;
	}
	
	
	public Node delete(String key) {
		Node current = first;
		Node previous = first;
		while(!key.equals(current.info.getKey())) {
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
}
