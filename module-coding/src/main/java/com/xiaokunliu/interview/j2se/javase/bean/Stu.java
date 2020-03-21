package com.xiaokunliu.interview.j2se.javase.bean;

import java.io.Serializable;

public class Stu implements Serializable {

    private static final long serialVersionUID = 2904188574618699632L;

    private String name;
    private Integer age;


    public Stu(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Stu() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Stu [name=" + name + ", age=" + age + "]";
    }
}
