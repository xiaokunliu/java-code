package com.xiaokunliu.j2ee.jpa.single.one2one;


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
public class JPAAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "detail")
    private String detail;

    // 单向 1 - 1 关联
    @OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = JPAUsers.class)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)  // 映射外键
    private JPAUsers users;

    public JPAAddress() {
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

    public JPAUsers getUsers() {
        return users;
    }

    public void setUsers(JPAUsers users) {
        this.users = users;
    }
}
