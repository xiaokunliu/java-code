package com.dtrees.study.core.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by keithl on 2017/11/8.
 * 声明事件
 */
public class DefineEvent extends ApplicationEvent{

    private String message;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public DefineEvent(Object source,String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
