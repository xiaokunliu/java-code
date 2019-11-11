package com.xiaokunliu.studycodes.ch09;

public class QuickSort {


	public static int partition(long arr[],int left, int right,long point) {
		int leftPtr = left - 1;
		int rightPtr = right;
		while(true) {

			while(leftPtr < rightPtr && arr[++leftPtr] < point);

			while(rightPtr > leftPtr && arr[--rightPtr] > point);
			if(leftPtr >= rightPtr) {
				break;
			} else {
				long tmp = arr[leftPtr];
				arr[leftPtr] =  arr[rightPtr];
				arr[rightPtr] = tmp;
			}
		}

		long tmp = arr[leftPtr];
		arr[leftPtr] =  arr[right];
		arr[right] = tmp;
		return leftPtr;
	}
	
	public static void displayArr(long[] arr) {
		System.out.print("[");
		for(long num : arr) {
			System.out.print(num + " ");
		}
		System.out.print("]");
		System.out.println();
	}
	
	public static void sort(long[] arr, int left, int right) {
		if(right - left <= 0) {
			return;
		}
		long point = arr[right];

		int partition = partition(arr, left, right, point);

		sort(arr,left,partition - 1);

		sort(arr,partition + 1, right);
	}
}
