package com.xiaokunliu.j2ee.jpa.life;

import javax.persistence.*;

/**
 * project:java-code
 * file:PersonListener
 * package:com.xiaokunliu.j2ee.jpa.life
 * date:2019/10/2 14:24
 * author:keithl
 */
public class PersonListener {

    @PrePersist
    public void prePersist() {

        // ...
    }

    @PostPersist
    public void postPersist() {

    }

    @PreUpdate
    public void preUpdate() {

    }

    @PostUpdate
    public void postUpdate() {

    }

    @PostLoad
    public void postLoad() {

    }

    @PreRemove
    public void preRemove() {

    }

    @PostRemove
    public void postRemove() {

    }
}
