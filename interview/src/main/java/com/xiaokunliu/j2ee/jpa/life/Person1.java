package com.xiaokunliu.j2ee.jpa.life;

import com.xiaokunliu.j2ee.jpa.extend_relations.Address;

import javax.persistence.*;

/**
 * project:java-code
 * file:Person
 * package:com.xiaokunliu.j2ee.jpa.extend_relations
 * date:2019/10/2 13:22
 * author:keithl
 */
@Entity
@Table(name = "ss_person")
@Inheritance(strategy = InheritanceType.JOINED)
@EntityListeners(PersonListener.class)
public class Person1 {

    // 使用专门的监听器进行回调
    // 生命周期的方法必须满足以下两个条件
    /**
     * 1。 生命周期的方法满足public void methodName的方法签名，
     * 2。 生命周期的方法可以有任何名称，但不要使用ejb开头
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private char gender;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "detail", column = @Column(name = "address_detail")),
            @AttributeOverride(name = "zip", column = @Column(name = "address_zip")),
            @AttributeOverride(name = "country", column = @Column(name = "address_country")),
    })
    private Address address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
