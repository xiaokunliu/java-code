package com.dtrees.mongodb.service;

import com.dtrees.mongodb.dao.YxTestDao;
import com.dtrees.mongodb.dao.YxTestRepository;
import com.dtrees.mongodb.domain.YxTest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YxTestService {

    @Autowired
    private YxTestDao yxTestDao;

    @Autowired
    private YxTestRepository yxTestRepository;

    public YxTest findOneById(String id){
        if(StringUtils.isNotBlank(id)){
            return yxTestDao.findOneById(id);
        }
        return null;
    }

    public YxTest findById(String id){
        if(StringUtils.isNotBlank(id)){
            return yxTestRepository.findOne(id);
        }
        return null;
    }
}
