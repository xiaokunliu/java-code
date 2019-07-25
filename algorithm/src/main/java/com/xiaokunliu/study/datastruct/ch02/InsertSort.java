package com.xiaokunliu.study.datastruct.ch02;//package ch02;

public class InsertSort {
	
	public static void sort(long[] arr) {
		long tmp = 0;
		
		for(int i = 1; i < arr.length; i++) {
			tmp = arr[i];
			int j = i;
			while(j > 0 && arr[j-1] >= tmp) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = tmp;
		}
	}

	public static void main(String[] args) {
		long[] arr = new long[5];
		arr[0] = 2;
		arr[1] = 34;
		arr[2] = 23;
		arr[3] = 1;
		arr[4] = -4;
		
		System.out.print("[");
		for(long num : arr) {
			System.out.print(num + " ");
		}
		System.out.print("]");
		System.out.println();
		
		sort(arr);
		
		System.out.print("[");
		for(long num : arr) {
			System.out.print(num + " ");
		}
		System.out.print("]");
		System.out.println();
		
	}
}
