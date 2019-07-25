package com.xiaokunliu.study.springinaction.assembly.placeholder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by keithl on 2017/11/15.
 */
@Component
public class SpELBean implements Serializable{

    private String title;

    private String age;

    public SpELBean(@Value("#{systemProperties['title']}") String title,
                    @Value("#{systemProperties['age']}") String age) {
        this.title = title;
        this.age = age;
    }

}
