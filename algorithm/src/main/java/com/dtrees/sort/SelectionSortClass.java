package com.dtrees.sort;

/**
 * Created by keithl on 2017/5/13.
 * 选择排序
 */
public class SelectionSortClass extends SortClass{


    public static void main(String[] args){
        int[] arr = {9,10,3,4,13,6,7};
        print(arr);
        heapSort(arr);
        //insertSort(arr);
        //selectSort(arr);
        print(arr);
    }


    /**
     * 简单选择排序的基本思想：比较+交换
     *  1.从待排序序列中，找到关键字最小的元素；
        2.如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换；
        3. 从余下的 N - 1 个元素中，找出关键字最小的元素，重复(1)、(2)步，直到排序结束。
             因此我们可以发现，简单选择排序也是通过两层循环实现。
             第一层循环：依次遍历序列当中的每一个元素
             第二层循环：将遍历得到的当前元素依次与余下的元素进行比较，符合最小元素的条件，则交换。
     */
    public static void selectSort(int[] arr){
        int len = arr.length;
        for (int i = 0;i < len; i ++){
            for (int j = i+1; j< len; j++){
                if (arr[j] < arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    //堆排序  ==> 树形的选择排序
    /**
     * 堆的概念
     本质是一种数组对象。特别重要的一点性质：任意的叶子节点小于（或大于）它所有的父节点。对此，又分为大顶堆和小顶堆，
     大顶堆要求节点的元素都要大于其孩子，小顶堆要求节点元素都小于其左右孩子，两者对左右孩子的大小关系不做任何要求。
     利用堆排序，就是基于大顶堆或者小顶堆的一种排序方法
     基本算法:
     1)首先将序列构建称为大顶堆,位于根节点的元素一定是当前序列的最大值
     2)取出当前大顶堆的根节点，将其与序列末尾元素进行交换；
     （此时：序列末尾的元素为已排序的最大值；由于交换了元素，当前位于根节点的堆并不一定满足大顶堆的性质
     3)因2)的操作,必须要对交换后的n-1个序列元素进行调整，使其满足大顶堆的性质
     4)重复2.3步骤，直至堆中只有1个元素为止
     */
    public static void heapSort(int[] arr){

        //构建大顶堆 ==> 得到最顶堆
        int len = arr.length;
        buildMaxHeap(arr,len);

        //初始化堆中的序列长度
        for (int index = len-1;index >= 0; index -- ){
            //将堆顶元素至尾
            int temp = arr[index];
            arr[index] = arr[0];
            arr[0] = temp;
//            print(arr);
            adjustMaxHeap(arr,index,0);
        }

        //执行循环：1. 每次取出堆顶元素置于序列的最后(len-1,len-2,len-3...)
        //         2. 调整堆，使其继续满足大顶堆的性质，注意实时修改堆中序列的长度
    }

    //构建初始化堆
    private static void buildMaxHeap(int[] arr,int len){
        for (int i = len/2 ;i >=0 ;i--){
//            print(arr);
            adjustMaxHeap(arr,len,i);
//            print(arr);
        }
    }

    //调整大顶堆
    private static void adjustMaxHeap(int[] arr,int len,int root){
        int max = root;
        while (true){
            //比较左右节点
            int left = root * 2 + 1;
            int right = root * 2 + 2;

            //与左节点做比较
            if (left < len && arr[left] > arr[root]){
                max = left;
            }

            if (right < len && arr[right] > arr[max]){
                max = right;
            }

            if (max == root){
                break;
            }

            int temp = arr[root];
            arr[root] = arr[max];
            arr[max] = temp;
            root = max;
        }
    }
}
