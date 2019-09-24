package com.xiaokunliu.study.springinaction.aop.xml;


/**
 * Created by keithl on 2017/10/17.
 */
public class AopBlankDisc implements AopCompactDisc {

    @Override
    public void play(String trackNumber) {
        System.out.println(trackNumber + " AOP AopBlankDisc play .... ");
    }

}
