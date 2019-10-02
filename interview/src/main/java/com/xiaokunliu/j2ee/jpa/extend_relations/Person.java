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
@Table(name = "ss_person")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "person_type")
@DiscriminatorValue(value = "simple person")
public class Person {

    // 整个类层次对应一张表
    /**
     * Discriminator ： 分辨一条记录属于哪个实体，解决方案就是在表增加额外的一列，来区分每行记录到底是哪一行记录的实体，成为辨别者列
     * DiscriminatorColumn，配置辨别者列
     * DiscriminatorValue，指定辨别者的值
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
