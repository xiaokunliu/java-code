package com.xiaokunliu.stduy.javase.collection.list;

import com.xiaokunliu.stduy.javase.bean.Person;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Vector<Person> v = new Vector<Person>();
        v.addElement(new Person("xiao1", 12));
        v.addElement(new Person("xiao2", 14));
        v.addElement(new Person("xiao3", 16));
        v.addElement(new Person("xiao4", 18));
        v.addElement(new Person("xiao5", 20));
        v.addElement(new Person("xiao6", 22));

        Enumeration<Person> en = v.elements();
        while (en.hasMoreElements()) {
            Person p = en.nextElement();
            System.out.println(p.getName() + ":" + p.getAge());
        }

        System.out.println("===============");
        for (Enumeration<Person> e = v.elements(); e.hasMoreElements(); ) {
            Person p = e.nextElement();
            System.out.println(p.getName() + ":" + p.getAge());
        }

    }

    //void addElement(E obj)
    //     将指定的组件添加到此向量的末尾，将其大小增加 1。
    //int capacity()
    //     返回此向量的当前容量。
    //void clear()
    //     从此向量中移除所有元素。
    //Object clone()
    //     返回向量的一个副本。
    //boolean contains(Object o)
    //     如果此向量包含指定的元素，则返回 true。
    //boolean containsAll(Collection<?> c)
    //     如果此向量包含指定 Collection 中的所有元素，则返回 true。
    //void copyInto(Object[] anArray)
    //     将此向量的组件复制到指定的数组中。
    //E elementAt(int index)
    //     返回指定索引处的组件。
    //Enumeration<E> elements()
    //     返回此向量的组件的枚举。
    //void ensureCapacity(int minCapacity)
    //     增加此向量的容量（如有必要），以确保其至少能够保存最小容量参数指定的组件数。
    //boolean equals(Object o)
    //     比较指定对象与此向量的相等性。
    //E firstElement()
    //     返回此向量的第一个组件（位于索引 0) 处的项）。
    //E get(int index)
    //     返回向量中指定位置的元素。
    //int hashCode()
    //     返回此向量的哈希码值。
    //int indexOf(Object o)
    //     返回此向量中第一次出现的指定元素的索引，如果此向量不包含该元素，则返回 -1。
    //int indexOf(Object o, int index)
    //     返回此向量中第一次出现的指定元素的索引，从 index 处正向搜索，如果未找到该元素，则返回 -1。
    //void insertElementAt(E obj, int index)
    //     将指定对象作为此向量中的组件插入到指定的 index 处。
    //boolean isEmpty()
    //     测试此向量是否不包含组件。
    //E lastElement()
    //     返回此向量的最后一个组件。
    //int lastIndexOf(Object o)
    //     返回此向量中最后一次出现的指定元素的索引；如果此向量不包含该元素，则返回 -1。
    //int lastIndexOf(Object o, int index)
    //     返回此向量中最后一次出现的指定元素的索引，从 index 处逆向搜索，如果未找到该元素，则返回 -1。
    //E remove(int index)
    //     移除此向量中指定位置的元素。
    //boolean remove(Object o)
    //     移除此向量中指定元素的第一个匹配项，如果向量不包含该元素，则元素保持不变。
    //boolean removeAll(Collection<?> c)
    //     从此向量中移除包含在指定 Collection 中的所有元素。
    //void removeAllElements()
    //     从此向量中移除全部组件，并将其大小设置为零。
    //boolean removeElement(Object obj)
    //     从此向量中移除变量的第一个（索引最小的）匹配项。
    //void removeElementAt(int index)
    //     删除指定索引处的组件。
    //protected  void removeRange(int fromIndex, int toIndex)
    //     从此 List 中移除其索引位于 fromIndex（包括）与 toIndex（不包括）之间的所有元素。
    //boolean retainAll(Collection<?> c)
    //     在此向量中仅保留包含在指定 Collection 中的元素。
    //E set(int index, E element)
    //     用指定的元素替换此向量中指定位置处的元素。
    //void setElementAt(E obj, int index)
    //     将此向量指定 index 处的组件设置为指定的对象。
    //void setSize(int newSize)
    //     设置此向量的大小。
    //int size()
    //     返回此向量中的组件数。
    //List<E> subList(int fromIndex, int toIndex)
    //     返回此 List 的部分视图，元素范围为从 fromIndex（包括）到 toIndex（不包括）。
    //Object[] toArray()
    //     返回一个数组，包含此向量中以恰当顺序存放的所有元素。
    //<T> T[]
    //toArray(T[] a)
    //     返回一个数组，包含此向量中以恰当顺序存放的所有元素；返回数组的运行时类型为指定数组的类型。
    //String toString()
    //     返回此向量的字符串表示形式，其中包含每个元素的 String 表示形式。
    //void trimToSize()
    //     对此向量的容量进行微调，使其等于向量的当前大小。


}
