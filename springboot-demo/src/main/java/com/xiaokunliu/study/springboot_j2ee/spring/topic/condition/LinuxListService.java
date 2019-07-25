package com.xiaokunliu.study.springboot_j2ee.spring.topic.condition;

/**
 * Created by keithl on 2017/11/8.
 */

public class LinuxListService implements ListService{
    @Override
    public String showCmdName() {
        return "ls";
    }
}
