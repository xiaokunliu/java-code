package com.xiaokunliu.j2se.javase.generic;

public interface GenericInte<T> {

    @SuppressWarnings("hiding")
    <T> void addEle(T t);

    @SuppressWarnings("hiding")
    <T> boolean isExit();

    @SuppressWarnings("hiding")
    <T> T getEle();
}
