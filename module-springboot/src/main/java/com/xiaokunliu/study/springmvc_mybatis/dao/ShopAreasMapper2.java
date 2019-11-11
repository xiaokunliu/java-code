package com.xiaokunliu.study.springmvc_mybatis.dao;

import com.xiaokunliu.study.springmvc_mybatis.domain.ShopAreas;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * project:java-code
 * file:ShopAreasMapper
 * package:com.xiaokunliu.study.springmvc_mybatis.dao
 * date:2019/4/5 4:17 PM
 * author:keithl
 */
@Repository
@Mapper
public interface ShopAreasMapper2 {

    // 使用Mybatis注解的方式
//     <id column="id" property="id" javaType="long"/>
//        <result column="country_code" property="countryCode" javaType="java.lang.String"/>
//        <result column="province" property="province" javaType="java.lang.String"/>
//        <result column="city" property="city" javaType="java.lang.String"/>
//        <result column="town" property="town" javaType="java.lang.String"/>
//        <result column="street" property="street" javaType="java.lang.String"/>
    @Select("SELECT * FROM ss_areas WHERE id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "countryCode", column = "country_code"),
            @Result(property = "province", column = "province"),
            @Result(property = "city", column = "city"),
            @Result(property = "town", column = "town"),
            @Result(property = "street", column = "street")
    })
    ShopAreas findById(long id);


    @Select("SELECT * FROM ss_areas")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "countryCode", column = "country_code"),
            @Result(property = "province", column = "province"),
            @Result(property = "city", column = "city"),
            @Result(property = "town", column = "town"),
            @Result(property = "street", column = "street")
    })
    List<ShopAreas> findAll();

    @Insert("insert into ss_areas(country_code, province, city, town, street) VALUES (#{countryCode}, #{province}, #{city}, #{town}, #{street})")
    @Options(useGeneratedKeys = true)
    int save(ShopAreas areas);

    @Delete("delete from ss_areas where id = #{id}")
    int delete(@Param("id") Integer id);

    @Update("update ss_areas set country_code=#{countryCode}, province=#{province}, city=#{city}, town=#{town}, street=#{street} WHERE id = #{id}")
    void updateAreas(ShopAreas areas);


    // TODO
    // 使用一对一 / 一对多 / 多对多
    
    // 注解的动态的sql -- sql构建器

}
