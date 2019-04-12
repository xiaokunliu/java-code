package com.dtrees.study.springboot_j2ee.spring.web;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by keithl on 2017/11/29.
 */
@RestController     //  声明是一个控制器,并且返回数据时不需要@ResponseBody
public class RestWebParams {

    @RequestMapping(value = "/obj",produces = "application/json;charset=UTF-8")
    public Person getJson(Person person,HttpServletRequest request) {
        System.out.println(String.format("access the url[%s]", request.getRequestURL()));
        Person newPerson = new Person();
        newPerson.setId(person.getId());
        newPerson.setAge(person.getAge());
        newPerson.setName(person.getName());
        return newPerson;
    }
}

