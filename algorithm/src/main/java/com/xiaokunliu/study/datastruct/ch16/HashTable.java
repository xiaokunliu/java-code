package com.xiaokunliu.study.datastruct.ch16;

import java.math.BigInteger;

public class HashTable {
	private Info[] arr;
	

	public HashTable() {
		arr = new Info[100];
	}
	

	public HashTable(int maxSize) {
		arr = new Info[maxSize];
	}
	

	public void insert(Info info) {

		String key = info.getKey();

		int hashVal = hashCode(key);

		while(arr[hashVal] != null && arr[hashVal].getName() != null) {

			++hashVal;

			hashVal %= arr.length;
		}
		arr[hashVal] = info;
	}
	

	public Info find(String key) {
		int hashVal = hashCode(key);
		while(arr[hashVal] != null) {
			if(arr[hashVal].getKey().equals(key)) {
				return arr[hashVal];
			}
			++hashVal;
			hashVal %= arr.length;
		}
		return null;
	}
	

	public Info delete(String key) {
		int hashVal = hashCode(key);
		while(arr[hashVal] != null) {
			if(arr[hashVal].getKey().equals(key)) {
				Info tmp = arr[hashVal];
				tmp.setName(null);
				return tmp;
			}
			++hashVal;
			hashVal %= arr.length;
		}
		return null;
	}
	
	public int hashCode(String key) {
//		int hashVal = 0;
//		for(int i = key.length() - 1; i >= 0; i--) {
//			int letter = key.charAt(i) - 96;
//			hashVal += letter;
//		}
//		return hashVal;
		
		BigInteger hashVal = new BigInteger("0");
		BigInteger pow27 = new BigInteger("1");
		for(int i = key.length() - 1; i >= 0; i--) {
			int letter = key.charAt(i) - 96;
			BigInteger letterB = new BigInteger(String.valueOf(letter));
			hashVal = hashVal.add(letterB.multiply(pow27));
			pow27 = pow27.multiply(new BigInteger(String.valueOf(27)));
		}
		return hashVal.mod(new BigInteger(String.valueOf(arr.length))).intValue();
	}
}
