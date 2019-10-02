package com.xiaokunliu.j2ee.jpa.single.one2many;

import com.xiaokunliu.j2ee.jpa.Cat;
import com.xiaokunliu.j2ee.jpa.Name;
import com.xiaokunliu.j2ee.jpa.Season;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 定义实体类,通过添加注解的方式定义实体类与数据库的数据表映射关系
 * Entity = POJO + Annotation
 * date:2019/9/13 18:58
 * author:keithl
 */
@Entity
@Table(name = "ss_users")
public class JPAUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // 使用联合主键  -- 方式2
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "first", column = @Column(name = "first_name", length = 20)),
            @AttributeOverride(name = "last", column = @Column(name = "last_name", length = 20)),
    })
    private Name name;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_sex")
    private int userSex;

    /**
     * @Transient: 表示当Users对象持久化到数据库中的时候，atavar字段数据不会持久化到数据库
     */
    @Column(name = "user_atavar")
    @Transient
    private String atavar;

    @Enumerated(EnumType.ORDINAL)   // 设置枚举对应数据的映射
    @Column(name = "season")
    private Season season;

    @Temporal(TemporalType.DATE)    // 只保持日期，没有时间
    @Column(name = "birthday")
    private Date bitrhday;

    // 映射复合类型
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "cat_name", length = 20)),
            @AttributeOverride(name = "color", column = @Column(name = "cat_color", length = 20)),
    })
    private Cat cat;

    // 单向 1 一 对 N 的复合关联
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = JPAAddress.class)
    @JoinColumn(name = "user_id", nullable = false)     // 对应在address表中显示的外键字段user_id
    private Set<JPAAddress> addresses = new HashSet<>();

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

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Date getBitrhday() {
        return bitrhday;
    }

    public void setBitrhday(Date bitrhday) {
        this.bitrhday = bitrhday;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}

