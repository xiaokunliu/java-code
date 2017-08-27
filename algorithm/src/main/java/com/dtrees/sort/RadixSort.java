package com.dtrees.sort;

/**
 * Created by keithl on 17-5-18.
 */
public class RadixSort extends SortClass{

    public static void main(String[] args){
//        int[] arr = {9,10,3,4,13,6,7};
        int[] arr = {32,43,57,82,19,21};
        print(arr);
        radixSort(arr);
//        print(arr);
//        System.out.println(getNumByPosition(3,2));
    }

    /**
     * 基数排序：通过序列中各个元素的值，对排序的N个元素进行若干趟的“分配”与“收集”来实现排序。
     *  1. 分配：我们将L[i]中的元素取出，首先确定其个位上的数字，根据该数字分配到与之序号相同的桶中
     *  2.收集：当序列中所有的元素都分配到对应的桶中，再按照顺序依次将桶中的元素收集形成新的一个待排序列L[ ]
     *  对新形成的序列L[]重复执行分配和收集元素中的十位、百位...直到分配完该序列中的最高位，则排序结束
     * @param arr
     */
    public static void radixSort(int[] arr){

        //find the max number in arr and then know that
        int max = arr[0];
        for (int index = 1;index <= arr.length - 1; index ++){
            if (max < arr[index]){
                max = arr[index];
            }
        }

        //find the max num bite,for example,if the 9038 is the max in arr,then is 4 bite
        int times = 0;
        while (max > 0){
            max = max / 10;
            times++;
        }

        //start sort
        //store the counter at the bucket
        int[] count = new int[10]; // 0 - 9,start the counter number is 0
        int[] bucketSortedArr = new int[arr.length];  //store the bucket number sorted at the temporary

        //position ==> 当前位(个位，十位，百位....)
        for (int position = 1;position <= times; position++){
            //each time when sorted,have to set counter to 0
            for (int index = 0;index < 10;index++){
                count[index] = 0;
            }

            //counter the arr bite number
            for(int index=0; index<arr.length; index++){
                int biteNumber = getNumByPosition(arr[index],position);
                count[biteNumber]++;
            }

            //#count[i]表示第i个桶的右边界索引
            for (int index=1;index<10;index++){
                count[index] = count[index] + count[index-1];
            }

            //using the last index cause the last one is the max and then it should be put at the right
            for (int i = arr.length-1;i>=0;i--){
                int elementBitNum = getNumByPosition(arr[i],position);
                bucketSortedArr[count[elementBitNum] - 1] = arr[i];
                count[elementBitNum]--;
            }

            //copy bucket sorted arr to arr
            for (int index=0;index<arr.length;index++){
                arr[index] = bucketSortedArr[index];
            }
            print(arr);
        }
    }

    public static int getNumByPosition(int num,int position){
        int biteNumber = (int)(Math.pow(10,position-1));
        return (num/biteNumber) % 10;
    }
}
