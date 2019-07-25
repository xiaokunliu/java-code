package com.xiaokunliu.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * project:java-code
 * file:ShopAreas
 * package:com.xiaokunliu.study.springmvc_mybatis.domain
 * date:2019/4/5 4:13 PM
 * author:keithl
 */
public class ShopAreas implements Serializable {

    private long id;

    private String countryCode;

    private String province;

    private String city;

    private String town;

    private String street;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("countryCode", countryCode)
                .append("province", province)
                .append("city", city)
                .append("town", town)
                .append("street", street)
                .toString();
    }
}
