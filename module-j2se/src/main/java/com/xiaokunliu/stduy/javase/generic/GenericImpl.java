package com.xiaokunliu.stduy.javase.generic;

import com.xiaokunliu.stduy.javase.bean.Person;

public class GenericImpl implements GenericInte<Person> {

    @SuppressWarnings("hiding")
    @Override
    public <Person> void addEle(Person t) {

    }

    @SuppressWarnings("hiding")
    @Override
    public <Person> boolean isExit() {
        return false;
    }

    @SuppressWarnings("hiding")
    @Override
    public <Person> Person getEle() {
        return null;
    }

}
