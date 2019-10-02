package com.xiaokunliu.j2ee.jpa.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


/**
 * project:java-code
 * file:Employee
 * package:com.xiaokunliu.j2ee.jpa.extend_relations
 * date:2019/10/2 13:32
 * author:keithl
 */
@Entity
@Table(name = "ss_employee")
@AssociationOverride(name = "address", joinColumns = @JoinColumn(name = "employee_address"))
public class Employee extends Person1 {

    // DiscriminatorValue 增加辨别者列，同时在对应的值上加以区分

    private double salary;

    private String title;

    // other columns

    // setter and getter ....

    /**
     * Employee
     *  1。继承非实体类，但是具备JPA的实体性质，仍然可以使用EntityManager来进行管理操作
     *  2。与Address存在着关联关系,通过
     *      @AssociationOverride(name = "address", joinColumns = @JoinColumn(name = "employee_address"))
     *      来表明与Address实体类存在关联关系
     *
     */

}
