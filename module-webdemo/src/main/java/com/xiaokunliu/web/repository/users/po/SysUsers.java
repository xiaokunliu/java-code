package com.xiaokunliu.web.repository.users.po;

import com.xiaokunliu.web.infrastructure.db.AutoId;
import com.xiaokunliu.web.infrastructure.db.DBColumn;
import com.xiaokunliu.web.infrastructure.db.DBTable;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * date:2019/11/22 20:55
 * author:keithl
 * desc: business desc etc.
 */
@DBTable(name = "sys_user")
public class SysUsers {

    @AutoId
    @DBColumn(name = "user_id")
    private long userId;

    @DBColumn(name = "dept_id")
    private long deptId;

    @DBColumn(name = "login_name", len = 30)
    private String loginName;

    @DBColumn(name = "user_name", len = 30)
    private String userName;

    @DBColumn(name = "user_type", len = 2)
    private String userType;

    @DBColumn(name = "email", len = 50)
    private String email;

    @DBColumn(name = "phonenumber", len = 11)
    private String phonenumber;

    @DBColumn(name = "sex", len = 1)
    private String sex;

    @DBColumn(name = "avatar")
    private String avatar;

    @DBColumn(name = "password", len = 50)
    private String password;

    @DBColumn(name = "salt", len = 20)
    private String salt;

    @DBColumn(name = "status", len = 2)
    private String status;

    @DBColumn(name = "del_flag", len = 2)
    private String delFlag;

    @DBColumn(name = "login_ip", len = 50)
    private String loginIP;

    @DBColumn(name = "login_date")
    private Date loginDate;

    @DBColumn(name = "create_by")
    private String createdBy;

    @DBColumn(name = "create_time")
    private Date createdTime;

    @DBColumn(name = "update_by")
    private String updatedBy;

    @DBColumn(name = "update_time")
    private Date updateTime;

    @DBColumn(name = "remark", len = 500)
    private String remark;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getLoginIP() {
        return loginIP;
    }

    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userId", userId)
                .append("deptId", deptId)
                .append("loginName", loginName)
                .append("userName", userName)
                .append("userType", userType)
                .append("email", email)
                .append("phonenumber", phonenumber)
                .append("sex", sex)
                .append("avatar", avatar)
                .append("password", password)
                .append("salt", salt)
                .append("status", status)
                .append("delFlag", delFlag)
                .append("loginIP", loginIP)
                .append("loginDate", loginDate)
                .append("createdBy", createdBy)
                .append("createdTime", createdTime)
                .append("updatedBy", updatedBy)
                .append("updateTime", updateTime)
                .append("remark", remark)
                .toString();
    }
}
