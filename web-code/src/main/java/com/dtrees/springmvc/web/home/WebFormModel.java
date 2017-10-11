package com.dtrees.springmvc.web.home;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by keithl on 2017/9/29.
 */

public class WebFormModel {

    // @AssertFalse:所注解的元素必须是Boolean类型，并且值为false

    // @AssertTrue:所注解的元素必须是Boolean类型，并且值为true

    // @DecimalMax:所注解的元素必须是数字，并且它的值要小于或等于给定的BigDecimalString值

    // @DecimalMin:所注解的元素必须是数字，并且它的值要大于或等于给定的BigDecimalString值

    // @Digits:所注解的元素必须是数字，并且它的值必须有指定的位数

    //@Future:所注解的元素的值必须是一个将来的日期

//    @Max 所注解的元素必须是数字，并且它的值要小于或等于给定的值

//    @Min 所注解的元素必须是数字，并且它的值要大于或等于给定的值

//    @NotNull:所注解元素的值必须不能为null

//    @Null:所注解元素的值必须为null

//    @Past:所注解的元素的值必须是一个已过去的日期

//    @Pattern:所注解的元素值必须是String,集合,数组,并且它的长度要符合给定的范围

    private Long id;

    @NotNull
    @Size(min = 5,max = 16)
    private String username;

    @NotNull
    @Size(min = 5,max = 25)
    private String pssword;

    @NotNull
    @Size(min = 2,max = 30)
    private String firstname;

    @NotNull
    @Size(min = 2,max = 20)
    private String lastname;    // 非空,2个20个字符

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPssword() {
        return pssword;
    }

    public void setPssword(String pssword) {
        this.pssword = pssword;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
