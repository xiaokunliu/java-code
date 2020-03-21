package com.xiaokunliu.interview.j2se.javase.collection;

import com.xiaokunliu.interview.j2se.javase.bean.Person;
import com.xiaokunliu.interview.j2se.javase.bean.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class CollectionDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {


        Collection<Person> coll = new ArrayList<Person>();
        coll.add(new Person("xin1", 18));
        coll.add(new Person("xin2", 19));
        coll.add(new Person("xin3", 20));
        coll.add(new Person("xin4", 21));

        Collection<Person> col = new ArrayList<Person>();
        col.add(new Person("xin1", 18));
        col.add(new Person("xin4", 21));
//		
//		removeAll(coll, col);
//		retainAll(coll, col);

        //boolean retainAll(Collection<?> c)
        //     仅保留此 collection 中那些也包含在指定 collection 的元素（可选操作）。

//		RemoveAndContains(coll);

//		//迭代-1
//		Iterator_1(coll);
//		System.out.println("=========================");
////		//迭代-2
//		Iterator_2(coll2);
//		System.out.println("=========================");
//		//迭代-3
//		Iterator_3(coll2);

    }


    public static void retainAll(Collection<Person> coll, Collection<Person> col) {
        System.out.println("coll---->" + coll);
        System.out.println("col----->" + col);
//		boolean removeAll(Collection<?> c) 
        //     移除此 collection 中那些也包含在指定 collection 中的所有元素（可选操作）
        //coll：只剩下与col：xin1，xin4;coll与col的互补，coll=col,即获取交集，注意如果没有重新覆盖equals方法将使得
        //对对象的操作将无法进行，底层是使用该方法来判断和操作的
        coll.retainAll(col);
        System.out.println("coll---->" + coll);
        System.out.println("col----->" + col);
    }


    public static void removeAll(Collection<Person> coll, Collection<Person> col) {
        System.out.println("coll---->" + coll);
        System.out.println("col----->" + col);
//		boolean removeAll(Collection<?> c) 
        //     移除此 collection 中那些也包含在指定 collection 中的所有元素（可选操作）
        //coll：只剩下xin2，xin3，col：xin1，xin4;coll与col的互补，coll+col=原来的coll，必须重新覆盖equals方法，底层是通过
//		该方法来进行判断和操作的
        coll.removeAll(col);
        System.out.println("coll---->" + coll);
        System.out.println("col----->" + col);
    }


    public static void Iterator_3(Collection<Student> coll2) {
        for (Student s : coll2) {
            System.out.println(s.getName() + ":" + s.getAge());
        }
    }


    public static void Iterator_2(Collection<Student> coll2) {
        Iterator<Student> it = coll2.iterator();
        while (it.hasNext()) {
            Student p = it.next();
            System.out.println(p.getName() + ":" + p.getAge());
        }
    }


    public static void Iterator_1(Collection<Person> coll) {
        for (Iterator<Person> iterator = coll.iterator(); iterator.hasNext(); ) {
            Person person = iterator.next();
            System.out.println(person.getName() + ":" + person.getAge());
        }
    }
    //	 boolean add(E e)
    //     确保此 collection 包含指定的元素（可选操作）。
    //boolean addAll(Collection<? extends E> c)
    //     将指定 collection 中的所有元素都添加到此 collection 中（可选操作）。
    //void clear()
    //     移除此 collection 中的所有元素（可选操作）。
    //boolean contains(Object o)
    //     如果此 collection 包含指定的元素，则返回 true。
    //boolean containsAll(Collection<?> c)
    //     如果此 collection 包含指定 collection 中的所有元素，则返回 true。
    //boolean equals(Object o)
    //     比较此 collection 与指定对象是否相等。
    //int hashCode()
    //     返回此 collection 的哈希码值。
    //boolean isEmpty()
    //     如果此 collection 不包含元素，则返回 true。
    //Iterator<E> iterator()
    //     返回在此 collection 的元素上进行迭代的迭代器。
    //boolean remove(Object o)
    //     从此 collection 中移除指定元素的单个实例，如果存在的话（可选操作）。
    //boolean removeAll(Collection<?> c)
    //     移除此 collection 中那些也包含在指定 collection 中的所有元素（可选操作）。
    //boolean retainAll(Collection<?> c)
    //     仅保留此 collection 中那些也包含在指定 collection 的元素（可选操作）。
    //int size()
    //     返回此 collection 中的元素数。
    //Object[] toArray()
    //     返回包含此 collection 中所有元素的数组。
    //<T> T[]
    //toArray(T[] a)
    //     返回包含此 collection 中所有元素的数组；返回数组的运行时类型与指定数组的运行时类型相同。

    public static void RemoveAndContains(Collection<Person> coll) {
        System.out.println(coll.size());
        boolean is = coll.remove(new Person("xin4", 21));//true
        //底层“删除/包含”依赖于equals方法来判断两个对象时否相同
//		boolean is2=coll.contains(new Person("xin4",21));//true
        System.out.println(is);
        System.out.println(coll.size());
    }

}
