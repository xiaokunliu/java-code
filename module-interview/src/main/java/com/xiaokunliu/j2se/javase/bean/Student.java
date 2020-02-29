package com.xiaokunliu.j2se.javase.bean;

/**
 * Created by keithl on 2017/9/3.
 */

public class Student extends Person {

    private String name;
    private Integer age;

    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Student(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
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
        return "Student [name=" + name + ", age=" + age + "]";
    }
}
