package com.xiaokunliu.j2ee.jpa;

import javax.persistence.*;

/**
 * project:java-code
 * file:Address
 * package:com.xiaokunliu.j2ee.jpa
 * date:2019/10/2 10:27
 * author:keithl
 */
@Entity
@Table(name = "ss_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "detail")
    private String detail;

    // 单向 N - 1 关联
//    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Users.class)
//    @JoinColumn(name = "user_id", nullable = false, updatable = false)  // 映射外键
//    private Users users;

    // 单向 1 - 1 关联
    @OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Users.class, mappedBy = "user")
    @JoinColumn(name = "user_id", nullable = false, updatable = false)  // 映射外键
    private Users users;

    /**
     * 单向关联 -- 只需要在一个类中添加对应的约束注解即可
     * 双向关联 -- 需要同时在两个关联的类中添加对应的关联约束注解，同时需要设置对应的信息如下
     * 双向 1 - 1：
     * 在Users添加注解OneToOne并添加字段 mappedBy = "user"， 表示Users不再控制实体关联关系
     * 在Address添加注解OneToOne，并使用JoinColumn
     */

    public Address() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
