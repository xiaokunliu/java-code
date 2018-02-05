package com.dtrees.study.spring.web.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by keithl on 2017/11/29.
 */
@ControllerAdvice   // 声明是一个控制器建言
public class ExceptionHandlerAdvice {

    // 在此处定义全局处理,通过@ExceptionHandler的value属性可过滤拦截的条件,这里是拦截所有的Exception
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage",exception.getMessage());
        return modelAndView;
    }

    // 将键值添加到全局,所有注解的@RequestMapping的方法均可以获取此键值
    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("message","another message");
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
    }
}
