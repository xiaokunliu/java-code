package com.dtrees.mongodb.service;

import com.dtrees.mongodb.dao.YxTestDao;
import com.dtrees.mongodb.domain.YxTest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YxTestService {

    @Autowired
    private YxTestDao yxTestDao;

    public YxTest findOneById(String id){
        if(StringUtils.isNotBlank(id)){
            return yxTestDao.findOneById(id);
        }
        return null;
    }
}
