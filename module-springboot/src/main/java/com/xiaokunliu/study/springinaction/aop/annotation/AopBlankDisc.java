package com.xiaokunliu.study.springinaction.aop.annotation;

import java.util.List;

/**
 * Created by keithl on 2017/10/17.
 */
public class AopBlankDisc implements AopCompactDisc {

    private String title;
    private String name;

    // 装配集合
    private List<String> list;

    public AopBlankDisc(String title, String name) {
        this.title = title;
        this.name = name;
    }

    @Override
    public void play(String trackNumber) {
        System.out.println(trackNumber + " AOP AopBlankDisc play .... ");
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {
        return list;
    }
}
