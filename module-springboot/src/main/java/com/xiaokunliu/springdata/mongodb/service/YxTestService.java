package com.xiaokunliu.springdata.mongodb.service;

import com.xiaokunliu.springdata.mongodb.dao.YxTestDao;
import com.xiaokunliu.springdata.mongodb.dao.YxTestRepository;
import com.xiaokunliu.springdata.mongodb.domain.YxTest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Cacheable(value = "YxTestService_findById")
    public YxTest findById(String id){
        if(StringUtils.isNotBlank(id)){
            Optional<YxTest> optionalYxTest = yxTestRepository.findById(id);
            return optionalYxTest.get();
        }
        return null;
    }
}
