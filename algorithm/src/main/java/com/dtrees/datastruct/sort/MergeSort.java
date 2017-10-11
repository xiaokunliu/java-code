package com.dtrees.datastruct.sort;

/**
 * Created by keithl on 17-5-18.
 */
public class MergeSort extends SortClass{


    public static void main(String[] args){
        int[] arr = {9,10,3,4,13,6,7};
        print(arr);
        mergedSort(arr,0,arr.length-1);
        print(arr);
    }

    /**
     * 1. 归并排序是建立在归并操作上的一种有效的排序算法，该算法是采用分治法的一个典型的应用。它的基本操作是：将已有的子序列合并，达到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
     * 2.  分解----将序列每次折半拆分
     *     合并----将划分后的序列段两两排序合并
     *     归并排序实际上就是两个操作，拆分+合并
     * 3.如何合并
     *      首先依次从第一段与第二段中取出元素比较，将较小的元素赋值给temp[]
     *      重复执行上一步，当某一段赋值结束，则将另一段剩下的元素赋值给temp[]
     *      此时将temp[]中的元素复制给L[]，则得到的L[first...last]有序
     * 4.分解
     *      待排序列分成A,B两组；然后重复对A、B序列
     *      分组；直到分组后组内只有一个元素，此时我们认为组内所有元素有序，则分组结束
     */
    public static void mergedSort(int[] arr,int first,int last){
        if(first < last){
            int mid = (first + last) / 2;

            //make left array sorted
            mergedSort(arr,first,mid);

            //make right array sorted
            mergedSort(arr,mid+1,last);

            //merge array
            mergeArray(arr,first,mid,last);
        }
    }

    private static void mergeArray(int[] arr,int first,int mid,int last){
        int[] temp = new int[last - first + 1];
        int low = first;
        int high = mid + 1;
        int index = 0;

        while ( low <= mid && high <= last){
            if(arr[low] <= arr[high]){
                temp[index++] = arr[low++];
            }else {
                temp[index++] = arr[high++];
            }
        }

        //left have rest
        while (low <= mid){
            temp[index++] = arr[low++];
        }

        //right have rest
        while (high <= last){
            temp[index++] = arr[high++];
        }

        //copy temp to arr
        for (int i=0;i<index;i++){
            arr[first + i] = temp[i];
        }
    }
}
