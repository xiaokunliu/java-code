package com.xiaokunliu.study.springboot_j2ee.spring.core.profiles;

/**
 * Created by keithl on 2017/11/8.
 */

public class ProfileBean {

    private String context;

    public ProfileBean(String context) {
        this.context = context;
    }

    public String getContext() {
        return context;
    }
}

