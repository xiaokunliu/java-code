package com.xiaokunliu.datastruct.sort;

/**
 * Created by keithl on 17-5-11.
 * 插入排序算法
 */
public class InsertSortClass extends SortClass{

    public static void main(String[] args){
        int[] arr = {9,10,3,4,13,6,7};
        print(arr);
        //insertSort(arr);
        shellSort(arr);
        print(arr);
    }


    /**
     * 直接插入排序的核心思想就是：将数组中的所有元素依次跟前面已经排好的元素相比较，如果选择的元素比已排序的元素小，则交换，直到全部元素都比较过。
     因此，从上面的描述中我们可以发现，直接插入排序可以用两个循环完成
     * @param arr
     */
    public static void insertSort(int[] arr){
        int len = arr.length;
        for (int i = 1;i < len; i++){  //  1 < n  1+1,2 < n, ... 1+n-1,n < n,2n - 1
            for (int j = i - 1; j >=0; j--){ //
                if (arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 希尔排序
     * 将待排序数组按照步长gap进行分组，然后将每组的元素利用直接插入排序的方法进行排序；
     * 每次将gap折半减小，循环上述操作；当gap=1时，利用直接插入，完成排序
     * 9,10,3,4,13,6,7
     *
     * 4 9
     * 13 10
     * 6 3
     * 4 10 3 9 13 6 7
     *
     * 4 10 3 9 13 6 7
     * 4 3
     */
    public static void shellSort(int[] arr){
        int len = arr.length;
        int gap = len / 2;
        while (gap >= 1){
            for(int last = gap;last < len;last ++){
                for (int first = last-gap;first >= 0;first -= gap){
                    if (arr[first] > arr[first + gap]){
                        int temp = arr[first+gap];
                        arr[first+gap] = arr[first];
                        arr[first] = temp;
                    }
                }
            }
            gap = gap / 2;
        }
    }
}
