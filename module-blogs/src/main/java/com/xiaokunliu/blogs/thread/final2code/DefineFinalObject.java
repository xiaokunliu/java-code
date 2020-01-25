package com.xiaokunliu.blogs.thread.final2code;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * date:2020/1/25 10:37
 * author:keithl
 * desc: business desc etc.
 */
public class DefineFinalObject {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("age", age)
                .toString();
    }
}
