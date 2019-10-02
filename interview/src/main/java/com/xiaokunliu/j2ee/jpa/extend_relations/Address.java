package com.xiaokunliu.j2ee.jpa.extend_relations;

/**
 * project:java-code
 * file:Address
 * package:com.xiaokunliu.j2ee.jpa.extend_relations
 * date:2019/10/2 13:22
 * author:keithl
 */
public class Address {

    private String detail;
    private String zip;
    private String country;

    public Address() {
    }

    public Address(String detail, String zip, String country) {
        this.detail = detail;
        this.zip = zip;
        this.country = country;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
