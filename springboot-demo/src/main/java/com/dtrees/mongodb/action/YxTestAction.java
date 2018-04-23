package com.dtrees.mongodb.action;

import com.dtrees.mongodb.domain.YxTest;
import com.dtrees.mongodb.service.YxTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class YxTestAction {

    @Autowired
    private YxTestService yxTestService;

    @RequestMapping("/list/${id}")
    public YxTest queryOne(@PathVariable String id){
        return yxTestService.findOneById(id);
    }

}
