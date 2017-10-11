package com.dtrees.springmvc.web.home;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by keithl on 2017/9/29.
 */
public class Spittle implements Serializable{

    private final Long id;
    private final Date time;
    private final String message;
    private Double latitude;
    private Double longitude;

    public Spittle(Date time, String message) {
        this(time,message,null,null);
    }

    public Spittle(Date time, String message, Double latitude, Double longitude) {
        this.id = null;
        this.time = time;
        this.message = message;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this,that,"id","time");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this,"id","time");
    }
}
