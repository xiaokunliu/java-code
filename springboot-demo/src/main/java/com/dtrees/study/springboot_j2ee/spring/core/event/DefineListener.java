package com.dtrees.study.springboot_j2ee.spring.core.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by keithl on 2017/11/8.
 * 事件监听类型
 */
@Component
public class DefineListener implements ApplicationListener<DefineEvent>{// 实现ApplicationListener接口,并指定监听的事件类型


    @Override
    public void onApplicationEvent(DefineEvent event) {// onApplicationEvent方法对消息进行接受处理
        String eventMessage = event.getMessage();
        System.out.println(String.format("i have received message[%s] from who container publish event",eventMessage));
    }
}
