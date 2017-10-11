package com.dtrees.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by keithl on 2017/9/28.
 * @RequestMapping 定义类级别的请求处理方式
 * @RequestMapping :能够接受一个String类型的数组,并且将他映射到对/homepage的请求
 */
@Controller
@RequestMapping({"/home3","/homepage"})
public class HomeController3 {

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        // 这时候可以映射到/home3 和 /homepage的两个url请求
        return "home3";
    }
}
