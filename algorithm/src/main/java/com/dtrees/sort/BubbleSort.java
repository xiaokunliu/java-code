package com.dtrees.sort;

/**
 * Created by keithl on 2017/5/13.
 * 交换排序
 */
public class BubbleSort extends SortClass{

    public static void main(String[] args){
        int[] arr = {9,10,3,4,13,6,7};
        print(arr);
//        bubbleSort(arr);
//        bubbleMaxSort(arr);
        quickSort(arr,0,arr.length-1);
        print(arr);
    }

    /**
     * 1. 将序列当中的左右元素，依次比较，保证右边的元素始终大于左边的元素； 第一轮结束后，序列最后一个元素一定是当前序列的最大值；or 序列第一个元素是当前序列最小值
       2. 对序列当中剩下的n-1个元素再次执行步骤1。
       3. 对于长度为n的序列，一共需要执行n-1轮比较,（利用while循环可以减少执行次数)
     */
    //当前序列是最小值
    public static void bubbleSort(int[] arr){
        int len = arr.length;
        for (int i = 1; i < len; i ++ ){
            for (int j = 0;j < len - i;j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    //当前序列最后一个是最大值
    public static void bubbleMaxSort(int[] arr){
        int len = arr.length;
        for (int i = len-1; i >= 0; i-- ){
            for (int j = i-1;j >=0; j--){
                if(arr[i] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    //快速排序
    public static void quickSort(int[] arr,int left,int right){
        if (left < right){
            return;
        }

        int pivot = arr[left];
        int i = left;
        int j = right;

        while (i!=j){
            while (i < j && arr[j] >= pivot){
                j --;
            }

            //have found the arr[right] < pivot

            //left
            while (i < j && arr[i] <= pivot){
                i ++;
            }

            //have found the arr[left] > pivot

            //swap left and right postion
            if (i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            //i >= j
            arr[left] = arr[i];
            quickSort(arr,left,i-1);
            quickSort(arr,i+1,right);
        }
    }
}
