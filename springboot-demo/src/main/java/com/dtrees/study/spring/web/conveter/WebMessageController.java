package com.dtrees.study.spring.web.conveter;

import com.dtrees.study.spring.web.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by keithl on 2017/11/30.
 */
@Controller
public class WebMessageController {

    @RequestMapping(value = "/converter",produces = {"application/x-wisely"})
    public @ResponseBody Person converter(@RequestBody Person person){
        return person;
    }
}
