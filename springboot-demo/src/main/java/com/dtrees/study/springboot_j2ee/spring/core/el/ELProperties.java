package com.dtrees.study.springboot_j2ee.spring.core.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by keithl on 2017/11/8.
 */
@Component
public class ELProperties {

    @Value("j2ee attr")   // 注入普通字符串
    private String others;

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
}
