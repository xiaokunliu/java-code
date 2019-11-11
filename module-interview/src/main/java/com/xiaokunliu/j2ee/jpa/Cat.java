package com.xiaokunliu.j2ee.jpa;

import javax.persistence.Embeddable;

/**
 * project:java-code
 * file:Cat
 * package:com.xiaokunliu.j2ee.jpa
 * date:2019/10/2 10:18
 * author:keithl
 */
@Embeddable
public class Cat {

    private String name;
    private String color;

    public Cat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
