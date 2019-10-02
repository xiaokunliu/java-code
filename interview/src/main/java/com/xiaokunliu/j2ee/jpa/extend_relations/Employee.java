package com.xiaokunliu.j2ee.jpa.extend_relations;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * project:java-code
 * file:Employee
 * package:com.xiaokunliu.j2ee.jpa.extend_relations
 * date:2019/10/2 13:32
 * author:keithl
 */
@Entity
@Table
@DiscriminatorValue(value = "simple employee")
public class Employee extends Person {

    // DiscriminatorValue 增加辨别者列，同时在对应的值上加以区分

    private double salary;

    private String title;

    // other columns

    // setter and getter ....


}
