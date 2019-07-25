package com.xiaokunliu.javase.bean;

/**
 * Created by keithl on 2017/9/3.
 */

public class Worker extends Person {
    private String name;
    private Integer age;
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

    public Worker() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Worker(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Worker [name=" + name + ", age=" + age + "]";
    }
}
