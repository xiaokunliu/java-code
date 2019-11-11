package com.xiaokunliu.j2ee.jpa.double2.many2many;

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

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "addresses", fetch = FetchType.LAZY, targetEntity = JPAUsers.class)
    private JPAUsers jpaUsers;

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

}
