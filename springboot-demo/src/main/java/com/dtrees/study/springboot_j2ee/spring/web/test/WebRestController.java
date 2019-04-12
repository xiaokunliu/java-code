package com.dtrees.study.springboot_j2ee.spring.web.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by keithl on 2017/11/30.
 */
@RestController
public class WebRestController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/testRest",produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getResult(){
        return demoService.saySomething();
    }
}
