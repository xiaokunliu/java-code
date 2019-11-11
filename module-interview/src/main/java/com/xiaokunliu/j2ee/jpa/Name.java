package com.xiaokunliu.j2ee.jpa;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * project:java-code
 * file:Name
 * package:com.xiaokunliu.j2ee.jpa
 * date:2019/10/2 10:23
 * author:keithl
 */
public class Name {

    private String first;
    private String last;

    public Name() {
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Name)) return false;

        Name name = (Name) o;

        return new EqualsBuilder()
                .append(getFirst(), name.getFirst())
                .append(getLast(), name.getLast())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getFirst())
                .append(getLast())
                .toHashCode();
    }
}
