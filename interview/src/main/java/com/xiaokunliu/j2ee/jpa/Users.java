package com.xiaokunliu.j2ee.jpa;

import javax.persistence.*;

/**
 * 定义实体类,通过添加注解的方式定义实体类与数据库的数据表映射关系
 * Entity = POJO + Annotation
 * date:2019/9/13 18:58
 * author:keithl
 */

/**
 * POJO:
 *      1. It doesn’t have special restrictions other than those forced by Java language.
 *      2. It doesn’t provide much control on members.
 *      3. It can implement Serializable interface.
 *      4. Fields can be accessed by their names.
 *      5. Fields can have any visiblity.
 *      6. There can be a no-arg constructor.
 *      7. It is used when you don’t want to give restriction on your members and give user complete access of your entity
 * JavaBean:
 *      1. It is a special POJO which have some restrictions
 *      2. It provides complete control on members.
 *      3. It should implement serializable interface.
 *      4. Fields are accessed only by getters and setters.
 *      5. Fields have only private visiblity.
 *      6. It must have a no-arg constructor.
 *      7. It is used when you want to provide user your entity but only some part of your entity.
 */
@Entity
@Table(name = "ss_users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_sex")
    private int userSex;

    @Column(name = "user_atavar")
    private String atavar;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getAtavar() {
        return atavar;
    }

    public void setAtavar(String atavar) {
        this.atavar = atavar;
    }
}

