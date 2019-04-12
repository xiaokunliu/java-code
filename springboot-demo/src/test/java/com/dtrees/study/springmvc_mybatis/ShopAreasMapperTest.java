package com.dtrees.study.springmvc_mybatis;

import com.dtrees.study.springmvc_mybatis.dao.ShopAreasMapper;
import com.dtrees.study.springmvc_mybatis.domain.ShopAreas;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * project:java-code
 * file:ShopAreasMapperTest
 * package:com.dtrees.study.springmvc_mybatis
 * date:2019/4/5 4:41 PM
 * author:keithl
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ShopAreasMapperTest {

    @Autowired
    private ShopAreasMapper shopAreasMapper;

    @Test
    public void testFindById(){
        ShopAreas shopAreas = shopAreasMapper.findById(1);
        System.out.println(shopAreas);
    }
}
