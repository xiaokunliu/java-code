package com.xiaokunliu.study.springinaction.aop.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy     // 启动AspectJ自动代理
@ComponentScan(basePackages = {"com.xiaokunliu.study.springinaction.aop.annotation"})
public class AnnConcertConfig {

    @Bean
    public AnnAudience annAudience(){
        return new AnnAudience();
    }

    @Bean
    public AnnMonitorAspect annEncorableAspect(){
        return new AnnMonitorAspect();
    }

    @Bean
    public AopCompactDisc aopCompactDisc(){
        AopBlankDisc aopBlankDisc = new AopBlankDisc("aop blank disc name", "aop blank disc title");
        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");
        stringList.add("D");
        stringList.add("E");
        stringList.add("F");

        aopBlankDisc.setList(stringList);
        return aopBlankDisc;
    }

    @Bean
    public AopTrackCounter trackCounter(){
        return new AopTrackCounter();
    }
}
