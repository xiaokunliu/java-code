package com.xiaokunliu.stduy.javase.stringTest;

/*
 * 1，给定一个字符串数组。按照字典顺序进行从小到大的排序。
 * {"nba","abc","cba","zz","qq","haha"}
 *
 *
 * 2，一个子串在整串中出现的次数。
 * "nbaernbatynbauinbaopnba"
 *
 *
 *
 * 3，两个字符串中最大相同的子串。
 *
 *
 *
 * 4，模拟一个trim功能一致的方法。
 */
public class StringTest {

    public static void main(String[] args) {

        String[] arr = {"nba", "abc", "cba", "zz", "qq", "haha"};
        printString(arr);
//		testSort_1(arr);
//		testSort_2(arr);
//		testSort_3(arr);
        testSort_4(arr);
        printString(arr);
    }

    /*
     * 冒泡排序加强
     */
    public static void testSort_4(String[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            String max = arr[i];
            int maxIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (max.compareTo(arr[j]) < 0) {
                    max = arr[j];
                    maxIndex = j;
                }
            }
            if (i != maxIndex)
                swap(arr, i, maxIndex);
        }
    }

    /*
     * 冒泡排序
     */
    public static void testSort_3(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0)
                    swap(arr, j, j + 1);
            }
        }
    }

    /*
     * 选择排序的加强
     */
    public static void testSort_2(String[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            String min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min.compareTo(arr[j]) > 0) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (i != minIndex)
                swap(arr, i, minIndex);
        }

    }

    public static void printString(String[] arr) {
        System.out.print("arr[");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1)
                System.out.print(arr[i] + ",");
            else
                System.out.println(arr[i] + "]");
        }
    }

    /*
     * 1，给定一个字符串数组。按照字典顺序进行从小到大的排序。
              {"nba","abc","cba","zz","qq","haha"}
          思路：
              1，排序，可以用选择排序、冒泡排序、..
              2，字符串的排序可以用compareTo方法来进行排序
              3，将排序后的字符串重新打印一下
     */
    /*
     * 选择排序
     */
    public static void testSort_1(String[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i].compareTo(arr[j]) > 0))
                    swap(arr, i, j);
            }
        }

    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
