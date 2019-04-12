package com.dtrees.springmvc.web.home;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by keithl on 2017/9/29.
 */
@Repository
public class SpittleResposityImpl implements SpittleRespository{

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittleList = Lists.newArrayList();
        for(int i = 0;i <= 10; i ++){
            spittleList.add(new Spittle(new Date(),"Spittle "+i));
        }
        return spittleList;
    }
}
