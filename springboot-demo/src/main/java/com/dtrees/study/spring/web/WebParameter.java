package com.dtrees.study.spring.web;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by keithl on 2017/11/29.
 */
@Controller
@RequestMapping("/params")
public class WebParameter {

    // 未标注路径,因此使用类级别的路径
    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public @ResponseBody String index(HttpServletRequest request){
        return String.format("access the url[%s]",request.getRequestURL());
    }

    @RequestMapping(value = "/path/{str}",produces = "text/plain;charset=UTF-8")
    public @ResponseBody String PathVar(@PathVariable String str, HttpServletRequest request){
        return String.format("access the url[%s] and the string code[%s]",request.getRequestURL(),str);
    }

    @RequestMapping(value = "/obj",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String processObject(Person person,HttpServletRequest request){
        return String.format("access the url[%s] get name[%s] and age[%d]",request.getRequestURL(),person.getName(),person.getAge());
    }


    @RequestMapping(value = {"/name1","/name2"},produces = "text/plain;charset=UTF-8")
    public @ResponseBody String remove(HttpServletRequest request) {
        return String.format("access the url[%s] to remove", request.getRequestURL());
    }
}
