package com.dtrees.study.springboot_j2ee.spring.web.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by keithl on 2017/11/30.
 */
@Controller
public class NormalController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/normal")
    public String testPage(Model model){
        model.addAttribute("message",demoService.saySomething());
        return "page";
    }
}
