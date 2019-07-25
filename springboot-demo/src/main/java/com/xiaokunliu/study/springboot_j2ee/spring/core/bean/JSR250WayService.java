package com.xiaokunliu.study.springboot_j2ee.spring.core.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by keithl on 2017/11/8.
 */

public class JSR250WayService {

    public JSR250WayService (){
        System.out.println("初始化构造函数JSR250WayService");
    }

    @PostConstruct      // 在构造函数执行完之后执行
    public void init(){
        System.out.println("@jsr250-init-method");
    }

    @PreDestroy         // 在bean销毁之前执行
    public void destroy(){
        System.out.println("@jsr250-destroy-method");
    }

}
