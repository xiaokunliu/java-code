package com.xiaokunliu.studycodes.ch03;

public class MyCycleQueue {

	private long[] arr;

	private int elements;

	private int front;

	private int end;
	

	public MyCycleQueue() {
		arr = new long[10];
		elements = 0;
		front = 0;
		end = -1;
	}

	public MyCycleQueue(int maxsize) {
		arr = new long[maxsize];
		elements = 0;
		front = 0;
		end = -1;
	}

	public void insert(long value) {
		if(end == arr.length - 1) {
			end = -1;
		}
		arr[++end] = value;
		elements++;
	}
	
	public long remove() {
		long value = arr[front++];
		if(front == arr.length) {
			front = 0;
		}
		elements--;
		return value;
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
