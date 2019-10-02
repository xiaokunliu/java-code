package com.xiaokunliu.j2ee.jpa;

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
@SecondaryTable(name = "ss_users_detail", pkJoinColumns = @PrimaryKeyJoinColumn(name = "user_id"))
@NamedQuery(name = "user_query", query = "select users.userName, users.userName from Users users where users.id > ?1")
//@IdClass(Name.class)  // 联合主键 -- 方式1
public class Users {

    // SecondaryTable: 实体映射到多个表，pkJoinColumns指定外键映射信息

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

//    // 单向 1 一 对 N 的复合关联
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Address.class)
//    @JoinColumn(name = "user_id", nullable = false)     // 对应在address表中显示的外键字段user_id
//    private Set<Address> addresses = new HashSet<>();

    // 单向 N - N 关联  建立中间表进行关联
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Address.class)
    @JoinTable(name = "user_address", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Set<Address> addresses = new HashSet<>();


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

    public Users(String userName, int userSex) {
        this.userName = userName;
        this.userSex = userSex;
    }

    public Users() {
    }
}

