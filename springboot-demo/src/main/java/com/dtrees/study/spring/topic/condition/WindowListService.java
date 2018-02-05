package com.dtrees.study.spring.topic.condition;

/**
 * Created by keithl on 2017/11/8.
 */

public class WindowListService implements ListService{

    @Override
    public String showCmdName() {
        return "dir";
    }
}
