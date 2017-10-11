package com.dtrees.datastruct.array;

/**
 * Created by keithl on 2017/10/11.
 * 有序数组 -- 查询的改进,使用二分查询
 */
public class OrderArrayObject extends ArrayObject{

    // 有序数组插入有待改进,TODO
    @Override
    public void insert(long value) {
        if (elements >= DEFAULT_SIZE){
            throw new ArrayIndexOutOfBoundsException(String.format("the arr elements have full,the max size is %d",DEFAULT_SIZE));
        }

        // find the value by search
        int findIndex = 0;
        for (int index = 0;index <= elements; index ++){
            if (arrList[index] >= value){
                findIndex = index;
                break;
            }
        }

        // add new elements
        for (int last = elements;last > findIndex; last --){
            arrList[last] = arrList[last-1];
        }
        arrList[findIndex] = value;
        elements ++;
    }

    // 查询的改进,使用二分查询,获得数组下标
    @Override
    public int search(long value) {
        int left = 0;
        int right = elements;
        int middle = 0;
        int index = -1;
        while (true){
            middle = (left + right) >> 1;
           if (arrList[middle] == value){
               index = middle;
               break;
           }

           //have not found the element
           if (left >= right){
                break;
           }

           if (arrList[middle] > value){
               right = middle - 1;
           }else if (arrList[middle] < value){
               left = middle + 1;
           }
        }
        return index;
    }
}
