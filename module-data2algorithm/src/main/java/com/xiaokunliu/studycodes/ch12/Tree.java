package com.xiaokunliu.studycodes.ch12;

public class Tree {

	public Node root;
	

	public void insert(long value,String sValue) {

		Node newNode = new Node(value,sValue);

		Node current = root;

		Node parent;

		if(root == null) {
			root = newNode;
			return;
		}
		while(true) {
			parent = current;
			if(current.data > value) {
				current = current.leftChild;
				if(current == null) {
					parent.leftChild = newNode;
					return;
				}
			} else {
				current = current.rightChild;
				if(current == null) {
					parent.rightChild = newNode;
					return;
				}
			}
		}
	}
	

	public Node find(long value) {
		Node current = root;
		while(current.data != value) {

			if(current.data > value) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}
			if(current == null) {
				return null;
			}
		}
		return current;
	}
	

	public void delte(long value) {
		
	}
	

	public void frontOrder(Node localNode) {
		if(localNode != null) {

			System.out.println(localNode.data + ", " + localNode.sData);

			frontOrder(localNode.leftChild);

			frontOrder(localNode.rightChild);
		}
	}
	

	public void inOrder(Node localNode) {
		if(localNode != null) {
			inOrder(localNode.leftChild);
			System.out.println(localNode.data + ", " + localNode.sData);
			inOrder(localNode.rightChild);
		}
	}
	

	public void afterOrder(Node localNode) {
		if(localNode != null) {
			afterOrder(localNode.leftChild);
			afterOrder(localNode.rightChild);
			System.out.println(localNode.data + ", " + localNode.sData);
		}
	}
}
