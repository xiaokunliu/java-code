package com.dtrees.datastruct.sort;

/**
 * Created by keithl on 2017/5/13.
 */
public class SortClass {

    public static void main(String[] args){
        int[] arr1 = {9,10,3,4,13,6,7};
        int[] arr2 = {9,10,3,4,13,6,7};
        int[] arr3 = {9,10,3,4,13,6,7};

        print(arr1);
        selectSort(arr1);
        print(arr1);

        print(arr2);
        bubbleSort(arr2);
        print(arr2);

        print(arr3);
        insertSort(arr3);
        print(arr3);
    }

    public static void print(int[] arr){
        for (int index = 0,len = arr.length;index < len;index ++){
            System.out.print(arr[index]+",");
        }
        System.out.println();
    }

    /**
     *  选择排序：在待排序的序列中，找到关键字最小的元素，与序列第一个元素进行比较互换，然后从第二个元素开始，重新查找关键字的最小元素，与第二个元素进行比较和互换
     *	冒泡排序：在待排序的序列中，逐个比较序列左右两边的元素，将最大元素排列后面，进行第一轮比较之后，得到最大元素排列在序列的最右边，然后再从序列的开始位置到序列的第二个位置开始比较并交换
     *	插入排序：在带排序的序列中，将序列中的所有元素依次与排序号的元素相比较，如果选择的排序比已排序的元素小，则交换位置
     */
    //the first min
    //select sort -- the first element
    public static void selectSort(int[] arr){
        for(int i = 0;i < arr.length; i++){
            for (int j = i+1;j < arr.length; j++){
                if (arr[i] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    //bubble sort
    public static void bubbleSort(int[] arr){
        for (int i = 1; i < arr.length; i ++){
            for (int j = 0; j < arr.length - i;j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    //insert sort
    public static void insertSort(int[] arr){
        for (int i = 1;i < arr.length; i ++){
            for (int j = i - 1;j >= 0; j--){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}
