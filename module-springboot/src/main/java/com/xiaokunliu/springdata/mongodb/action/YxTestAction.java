package com.xiaokunliu.springdata.mongodb.action;

import com.xiaokunliu.springdata.mongodb.domain.YxTest;
import com.xiaokunliu.springdata.mongodb.service.YxTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class YxTestAction {

    @Autowired
    private YxTestService yxTestService;

    @RequestMapping("/list/{id}")
    public YxTest queryOne(@PathVariable(name = "id") String id){
        return yxTestService.findOneById(id);
    }
}
