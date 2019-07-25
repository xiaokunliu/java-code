package com.xiaokunliu.study.datastruct.ch03;

public class MyQueue {

	private long[] arr;
	
	private int elements;

	private int front;

	private int end;
	

	public MyQueue() {
		arr = new long[10];
		elements = 0;
		front = 0;
		end = -1;
	}

	public MyQueue(int maxsize) {
		arr = new long[maxsize];
		elements = 0;
		front = 0;
		end = -1;
	}

	public void insert(long value) {
		arr[++end] = value;
		elements++;
	}
	

	public long remove() {
		elements--;
		return arr[front++];
	}
	

	public long peek() {
		return arr[front];
	}
	

	public boolean isEmpty() {
		return elements == 0;
	}
	

	public boolean isFull() {
		return elements == arr.length;
	}
}
