package com.xiaokunliu.j2ee.jpa.entity;

import com.xiaokunliu.j2ee.jpa.extend_relations.Address;

import javax.persistence.*;

/**
 * date:2019/10/2 13:22
 * author:keithl
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class Person1 {

    /**
     * 非实体父类：
     * 1。 在底层数据库中并没有对应的数据表
     * 2。 不能使用实体管理器EntityManager进行CRUD操作
     * 3。 不能使用@Entity修饰
     * 4。 使用@MappedSuperclass表示为非实体父类
     * 1)但是如果子类继承Person1，并有@Entity修饰仍然可以看成一个JPA的实体对象，仍然可以用EntityManager进行CRUD操作
     * 2)如果这个非实体父类存在与其他实体有着N-1，1-1关联关系，那么它的所有子类都可能需要增加额外的外键列记录对应的子类实体与其他实体之间的关联关系
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
