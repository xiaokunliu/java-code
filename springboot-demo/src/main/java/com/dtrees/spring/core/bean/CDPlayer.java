package com.dtrees.spring.core.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by keithl on 2017/10/17.
 */
@Component
public class CDPlayer implements MediaPlayer{

    private CompactDisc compactDisc;

    // 通过构造器自动装配
    @Autowired
    public CDPlayer(CompactDisc compactDisc){
        this.compactDisc = compactDisc;
    }

    // 通过设置器自动装配
    @Autowired
    public void setCompactDisc(CompactDisc compactDisc){
        this.compactDisc = compactDisc;
    }

    // 其他方法
    @Autowired
    public void insertCompactDisc(CompactDisc compactDisc){
        this.compactDisc = compactDisc;
    }

    public CompactDisc getCompactDisc(){
        return this.compactDisc;
    }
}
