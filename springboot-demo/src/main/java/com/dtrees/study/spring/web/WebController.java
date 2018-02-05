package com.dtrees.study.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by keithl on 2017/11/29.
 */
@Controller     // 聲明是一個控制器
public class WebController {

    @RequestMapping     // 配置方法和url方法之間的映射
    public String index(){
        return "index"; // 通過ViewResolver的Bean配置,返回index,說明我們的頁面存放的路徑是在/WEB-INF/classes/views/index.jsp
    }

//    @RequestMapping: 用來映射Web請求(訪問路徑和參數)、处理类和方法,可注解在类或者方法上
//    支持request和resse作为参数,也支持request和response的媒体类型进行配置

//    @RequestBody:允许request参数在request体中,而不是直接链接在地址后面,此注解放置在参数之前

//    @ResponseBody:支持返回值放在response的body内,而不是返回一个页面,可以在前端使用Ajax时候可以使用这个注解来返回数据而无需返回页面

//    @PathVariable:用来接受路径的参数,放在参数前

//    @RestController:这是一个组合注解,组合了@Controller和@ResponseBody,这意味着单你开发一个和页面交互的数据控制时候需要使用此注解



}
