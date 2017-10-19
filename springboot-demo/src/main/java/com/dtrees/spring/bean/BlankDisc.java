package com.dtrees.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by keithl on 2017/10/17.
 */

public class BlankDisc implements CompactDisc{

    private String title;
    private String name;

    // 装配集合
    private List<String> list;

    public BlankDisc(String title, String name) {
        this.title = title;
        this.name = name;
    }

    @Override
    public void play() {}

    @Autowired
    public void setTitle(String title){
        this.title = title;
    }

}
