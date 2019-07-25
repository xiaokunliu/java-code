package com.xiaokunliu.study.springboot_j2ee.spring.core.bean;

/**
 * Created by keithl on 2017/11/8.
 */

public class BeanWayService {

    public BeanWayService(){
        System.out.println("初始化构造函数BeanWayService");
    }

    public void init(){
        System.out.println("@Bean-init-method");
    }

    public void destroy(){
        System.out.println("@Bean-destroy-method");
    }
}
