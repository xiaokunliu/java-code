package com.dtrees.datastruct.sort;

/**
 * Created by keithl on 2017/5/13.
 * 交换排序  -- 冒泡排序
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
    //顺序交换
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

    //倒序交换
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
            // 从右边开始倒序遍历,逐个与基准数进行比较,如果比基准数小,那么就会停止遍历
            while (i < j && arr[j] >= pivot){
                j --;
            }

            // 找到右边数组数据比基准数要小
            //have found the arr[right] < pivot

            //left
            // 开始从左边的数组数据,如果左边的数据比基准数要大,那么就会停止遍历
            while (i < j && arr[i] <= pivot){
                i ++;
            }

            // 找到左边的数组的数据比基准数据要大
            //have found the arr[left] > pivot

            // 交换左大右小的两边数据
            //swap left and right postion
            if (i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            //i >= j
            // 将基准数与左边的数组数据进行交换
            arr[left] = arr[i];

            // 递归调用重排
            quickSort(arr,left,i-1);
            quickSort(arr,i+1,right);
        }
    }

    // 使用非递归的方式

}
