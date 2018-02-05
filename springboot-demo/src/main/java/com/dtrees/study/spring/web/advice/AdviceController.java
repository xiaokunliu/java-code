package com.dtrees.study.spring.web.advice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by keithl on 2017/11/29.
 */
@Controller
public class AdviceController {

    @RequestMapping
    public String getSomething(@ModelAttribute("messgae")String message){
        throw new IllegalArgumentException(String.format("so sorry,the parameter which comes from @ModelAttribute[%s] is error ",message));
    }


}
