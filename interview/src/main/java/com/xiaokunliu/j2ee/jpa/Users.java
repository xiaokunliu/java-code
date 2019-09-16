package com.xiaokunliu.j2ee.jpa;

import javax.persistence.*;

/**
 * project:java-code
 * file:Users
 * package:com.xiaokunliu.j2ee.jpa
 * date:2019/9/13 18:58
 * author:keithl
 */
@Entity
@Table(name = "ss_users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_sex")
    private int userSex;

    @Column(name = "user_atavar")
    private String atavar;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getAtavar() {
        return atavar;
    }

    public void setAtavar(String atavar) {
        this.atavar = atavar;
    }
}

