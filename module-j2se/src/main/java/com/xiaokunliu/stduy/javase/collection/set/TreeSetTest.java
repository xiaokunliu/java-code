package com.xiaokunliu.stduy.javase.collection.set;

import com.xiaokunliu.stduy.javase.bean.Person;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

//		TreeSet<Person> tr=new TreeSet<Person>(new DefineComparator());
        TreeSet<Person> tr = new TreeSet<Person>();
        //java.lang.ClassCastException: com.wind.bean.Person cannot be cast to java.lang.Comparable
        //原因是由于Person并没有实现Comparable或者是集合没有实现比较器的机制
        tr.add(new Person("xiao1", 1));
        tr.add(new Person("xiao4", 42));
        tr.add(new Person("xiao5", 5));
        tr.add(new Person("xiao2", 12));
        tr.add(new Person("xiao3", 32));


        for (Iterator<Person> iterator = tr.iterator(); iterator.hasNext(); ) {
            Person person = iterator.next();
            System.out.println(person.getName() + ":" + person.getAge());
        }
    }

}
