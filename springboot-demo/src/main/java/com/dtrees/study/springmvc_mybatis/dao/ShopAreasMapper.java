package com.dtrees.study.springmvc_mybatis.dao;

import com.dtrees.study.springmvc_mybatis.domain.ShopAreas;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * project:java-code
 * file:ShopAreasMapper
 * package:com.dtrees.study.springmvc_mybatis.dao
 * date:2019/4/5 4:17 PM
 * author:keithl
 */
@Repository
@Mapper
public interface ShopAreasMapper {

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    ShopAreas findById(long id);

}
