package com.dtrees.study.datastruct.ch13;

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
	
	/**
	 * ɾ���ڵ�
	 * @param value
	 */
	public boolean delete(long value) {

		Node current = root;

		Node parent = root;

		boolean isLeftChild = true;
		
		while(current.data != value) {
			parent = current;
			if(current.data > value) {
				current = current.leftChild;
				isLeftChild = true;
			} else {
				current = current.rightChild;
				isLeftChild = false;
			}

			if(current == null) {
				return false;
			}
		}
		

		if(current.leftChild == null && current.rightChild == null) {
			if(current == root) {
				root = null;
			} else if(isLeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		} else if(current.rightChild == null) {
			if(current == root) {
				root = current.leftChild;
			}else if(isLeftChild) {
				parent.leftChild = current.leftChild;
			} else {
				parent.rightChild = current.leftChild;
			}
		} else if(current.leftChild == null) {
			if(current == root) {
				root = current.rightChild;
			} else if(isLeftChild) {
				parent.leftChild = current.rightChild;
			} else {
				parent.rightChild = current.rightChild;
			}
		} else {
			Node successor = getSuccessor(current);
			if(current == root) {
				root = successor;
			} else if(isLeftChild) {
				parent.leftChild = successor;
			} else{
				parent.rightChild = successor;
			}
			successor.leftChild = current.leftChild;
		}
		
		return true;
		
		
	}
	
	public Node getSuccessor(Node delNode) {
		Node successor = delNode;
		Node successorParent = delNode;
		Node current = delNode.rightChild;
		
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		
		if(successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
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
