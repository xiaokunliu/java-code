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
        int findIndex = elements;
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

    // 使用递归查询
    public int binarySearch(int left,int right,int searchValue){
        int middle = (left + right) >> 1;
        if (arrList[middle] == searchValue) return middle;
        if (left >= right) return -1;
        return arrList[middle] > searchValue? binarySearch(left,middle-1,searchValue):binarySearch(middle+1,right,searchValue);
    }

    public static void main(String[] args) {
        OrderArrayObject orderArrayObject = new OrderArrayObject();

        orderArrayObject.insert(2);
        orderArrayObject.insert(9);
        orderArrayObject.insert(10);
        orderArrayObject.insert(3);
        orderArrayObject.insert(6);
        orderArrayObject.insert(5);

        orderArrayObject.display();

        int index = orderArrayObject.binarySearch(0,orderArrayObject.getLength()-1,5);
        System.out.println(index);
    }
}
