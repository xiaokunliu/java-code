package com.xiaokunliu.stduy.javase.collection.list;

import java.util.LinkedList;

public class Zhan<E> {

    private LinkedList<E> link;

    public Zhan() {
        link = new LinkedList<E>();
    }

    public void add(E e) {
        link.addFirst(e);
    }

    public E delete() {
        return link.removeFirst();
    }

    public boolean isEmpty() {
        return link.isEmpty();
    }


    public int length() {
        return link.size();
    }
}
