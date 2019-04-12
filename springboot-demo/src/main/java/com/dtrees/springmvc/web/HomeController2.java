package com.dtrees.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by keithl on 2017/9/28.
 * @RequestMapping 定义类级别的请求处理方式
 */
@Controller
@RequestMapping("/home2")
public class HomeController2 {

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "home2";
    }
}
