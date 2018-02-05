package com.dtrees.datastruct.list.array;

/**
 * 数组的特点:查询快,但是删除和添加慢
 * 自定义数组对象,参考ArrayList
 * 优化:转换为泛型通用型 TODO
 */
public class ArrayObject {

    protected long[] arrList;

    protected int elements = 0; // the arr number is default 0

    public static int DEFAULT_SIZE = 16;

    public ArrayObject() {
        arrList = new long[DEFAULT_SIZE];
    }

    public ArrayObject(int maxSize) {
        arrList = new long[maxSize];
    }

    public int getLength(){
        return elements;
    }

    public void insert(long value) {
        if (elements >= DEFAULT_SIZE){
            throw new ArrayIndexOutOfBoundsException("the arr elements have full");
        }
        arrList[elements] = value;
        elements++;
    }


    public void display() {
        System.out.print("[");
        for(int i = 0; i < elements; i++) {
            System.out.print(arrList[i] + " ");
        }
        System.out.println("]");
    }

    /**
     * 根据数组的值来查询
     * 查询数据可优化
     * @param value
     * @return
     */
    public int search(long value) {
        // 线性查询
        int i = 0;
        for(i = 0; i < elements; i++) {
            if(value == arrList[i]) {
                break;
            }
        }
        if(i == elements) {
            return -1;
        }
        return i;
    }

    /**
     * 根据索引来查询,查询可优化
     * @param index
     * @return
     */
    public long get(int index) {
        if(index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return arrList[index];
    }


    public void remove(int index) {
        if(index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i = index; i < elements; i++) {
            arrList[index] = arrList[index + 1];
        }
        elements--;
    }


    public void update(int index, long newValue) {
        if(index >= elements || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        arrList[index] = newValue;
    }
}
