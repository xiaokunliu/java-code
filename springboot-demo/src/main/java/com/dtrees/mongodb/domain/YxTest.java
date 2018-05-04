package com.dtrees.mongodb.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "yx_test")
public class YxTest implements Serializable{

    @Id
    private String id;
    private String url_for_show;
    private int activity_id;
    private String url;
    private String activityName;
    private String linkUrl;
    private String newOld;
    private int showId;
    private String pic_url;
    private int config_type;
    private String web_url;
    private Date end_time;
    private Date begin_time;
    private String roomids;
    private String url_for_pat;
    private String channelids;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl_for_show() {
        return url_for_show;
    }

    public void setUrl_for_show(String url_for_show) {
        this.url_for_show = url_for_show;
    }

    public int getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getNewOld() {
        return newOld;
    }

    public void setNewOld(String newOld) {
        this.newOld = newOld;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public int getConfig_type() {
        return config_type;
    }

    public void setConfig_type(int config_type) {
        this.config_type = config_type;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Date getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(Date begin_time) {
        this.begin_time = begin_time;
    }

    public String getRoomids() {
        return roomids;
    }

    public void setRoomids(String roomids) {
        this.roomids = roomids;
    }

    public String getUrl_for_pat() {
        return url_for_pat;
    }

    public void setUrl_for_pat(String url_for_pat) {
        this.url_for_pat = url_for_pat;
    }

    public String getChannelids() {
        return channelids;
    }

    public void setChannelids(String channelids) {
        this.channelids = channelids;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("url_for_show", url_for_show)
                .append("activity_id", activity_id)
                .append("url", url)
                .append("activityName", activityName)
                .append("linkUrl", linkUrl)
                .append("newOld", newOld)
                .append("showId", showId)
                .append("pic_url", pic_url)
                .append("config_type", config_type)
                .append("web_url", web_url)
                .append("end_time", end_time)
                .append("begin_time", begin_time)
                .append("roomids", roomids)
                .append("url_for_pat", url_for_pat)
                .append("channelids", channelids)
                .toString();
    }
}
