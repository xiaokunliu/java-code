package com.xiaokunliu.javase.map;

import com.xiaokunliu.javase.bean.Person;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by keithl on 2017/9/3.
 */

public class MapTest {

    public static void main(String[] args) {

        Map<Integer,Person> map=new HashMap<Integer,Person>();
        map.put(1, new Person("xiao1",11));
        map.put(6, new Person("xiao6",16));
        map.put(2, new Person("xiao2",12));
        map.put(4, new Person("xiao4",14));
        map.put(5, new Person("xiao5",15));
        map.put(3, new Person("xiao3",13));

        //Set<K> keySet()
        //     返回此映射中包含的键的 Set 视图。
//		iterator_1(map);
        System.out.println("=======================");
//		iterator_2(map);

        iterator_3(map);

    }

    public static void iterator_3(Map<Integer, Person> map) {
        for(Map.Entry<Integer, Person> entry:map.entrySet()){

            System.out.println("key:"+entry.getKey()+"--->value:"+entry.getValue());
        }
    }

    public static void iterator_2(Map<Integer, Person> map) {
        Iterator<Map.Entry<Integer, Person>> it=map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, Person> entry=it.next();
            System.out.println("key:"+entry.getKey()+"--->value:"+entry.getValue());
        }
    }

    private static void iterator_1(Map<Integer, Person> map) {
        Iterator<Integer> it=map.keySet().iterator();
        while(it.hasNext()){
            Integer key=it.next();
            Person value=map.get(key);
            System.out.println(key+":"+value);
        }
    }

    //boolean containsKey(Object key)
    //     如果此映射包含指定键的映射关系，则返回 true。
    //boolean containsValue(Object value)
    //     如果此映射将一个或多个键映射到指定值，则返回 true。
    //Set<Map.Entry<K,V>> entrySet()
    //     返回此映射中包含的映射关系的 Set 视图。
    //boolean equals(Object o)
    //     比较指定的对象与此映射是否相等。
    //V put(K key, V value)
    //     将指定的值与此映射中的指定键关联（可选操作）。
    //void putAll(Map<? extends K,? extends V> m)
    //     从指定映射中将所有映射关系复制到此映射中（可选操作）。
    //V remove(Object key)
    //     如果存在一个键的映射关系，则将其从此映射中移除（可选操作）。
    //int size()
    //     返回此映射中的键-值映射关系数。
    //Collection<V> values()
    //     返回此映射中包含的值的 Collection 视图。
}
