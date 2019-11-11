package com.xiaokunliu.study.springinaction.assembly.identifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by keithl on 2017/11/15.
 */
@Configuration
@ComponentScan("com.xiaokunliu.study.springinaction.assembly.identifier")
public class IdentifierBeanConfig {

    private Dessert dessert;

    @Autowired
//    @Qualifier("cake")
    @Sweet
    public void setDessert(Dessert dessert){
        this.dessert = dessert;
    }
}
