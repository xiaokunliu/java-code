package com.dtrees.javase.wrapper;

/*
 * 对一个字符串中的数值进行从小到大的排序。
 * 
 * "20 78 9 -7 88 36 29"
 */
public class WrapperTest {

	private static final String SPACE=" ";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str="20 78 9 -7 88 36 29";
		System.out.println(str);
		int[] arr=stringToNumArr(str);
//		printArry(arr);
		sortArr(arr);
//		printArry(arr);
		str=numToString(arr);
		System.out.println(str);
	}

	private static String numToString(int[] arr) {
		StringBuilder sb=new StringBuilder();
		for (int i : arr) {
			sb.append(i+SPACE);
		}
		return sb.toString();
	}

	public static void sortArr(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			int minIndex=i;
			int min=arr[i];
			for (int j = i+1; j < arr.length; j++) {
				if(min>arr[j]){
					min=arr[j];
					minIndex=j;
				}
			}
			if(i!=minIndex)
				swap(arr,i,minIndex);
		}
		
	}

	private static void swap(int[] arr, int i, int minIndex) {
		int temp=arr[i];
		arr[i]=arr[minIndex];
		arr[minIndex]=temp;
		
	}

	public static void printArry(int[] arr) {
		System.out.print("arr[ ");
		for (int i : arr) {
			System.out.print(i+SPACE);
		}
		System.out.println("]");
		
	}

	public static int[] stringToNumArr(String str) {
		
		String[] temp=str.split(SPACE);
		int[] arr=new int[temp.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=Integer.parseInt(temp[i]);
		}
		return arr;
	}

}
