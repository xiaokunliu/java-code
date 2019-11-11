package com.xiaokunliu.j2ee.jpa.life;

import javax.persistence.Entity;
import javax.persistence.ExcludeSuperclassListeners;
import javax.persistence.Id;
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
// @ExcludeSuperclassListeners 排除父类的监听器
@ExcludeSuperclassListeners
public class Employee extends Person1 {

    // DiscriminatorValue 增加辨别者列，同时在对应的值上加以区分
    @Id
    private long id;

    private double salary;

    private String title;

    // other columns

    // setter and getter ....


}
