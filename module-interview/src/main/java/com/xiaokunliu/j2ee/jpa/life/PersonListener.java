package com.xiaokunliu.j2ee.jpa.life;

import javax.persistence.*;

/**
 * date:2019/10/2 14:24
 * author:keithl
 */
public class PersonListener {

    @PrePersist
    public void prePersist(Object object) {

        // ...
    }

    @PostPersist
    public void postPersist(Object object) {

    }

    @PreUpdate
    public void preUpdate(Object object) {

    }

    @PostUpdate
    public void postUpdate(Object object) {

    }

    @PostLoad
    public void postLoad(Object object) {

    }

    @PreRemove
    public void preRemove(Object object) {

    }

    @PostRemove
    public void postRemove(Object object) {

    }
}
