package com.xiaokunliu.j2ee.jpa.extend_relations;

import javax.persistence.*;

/**
 * project:java-code
 * file:Person
 * package:com.xiaokunliu.j2ee.jpa.extend_relations
 * date:2019/10/2 13:22
 * author:keithl
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "ss_person")
public class Person2 {

    //每个具体类对应一张表的策略
    /**
     * Inheritance:不是JPA默认继承策略，父类实体保存在父类表中，而子类实体则由父类和子类表共同存储
     * SINGLE_TABLE：整个类层次连接对应一张表的策略
     * TABLE_PER_CLASS：每个具体类对应一张表的策略
     * JOINED：连接子类的映射策略
     * <p>
     * TABLE_PER_CLASS
     * GenerationType.AUTO/IDENTITY 都不能使用
     * 子类也不需要做任何的修改操作，DiscriminatorValue不需要加
     */
    @Id
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
