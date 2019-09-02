package com.xiaokunliu.j2ee.email;


import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * project:java-code
 * file:ReceiveEmailObject
 * package:com.xiaokunliu.j2ee.email
 * date:2019/7/30 8:27 PM
 * author:keithl
 */
public class ReceiveEmailObject implements Serializable {
    // 获取收件箱信息
//    private List<Message> emailMessageList;
    // 收件日期
    private Date receivedDate;
    // 抄送地址
    private List<String> ccAddress;
    // 文件前缀名称
    private String fileSuffix;
    // 附件
    private List<File> attachmentList;
    // 邮件正文
    private String content;
    // 是否已读
    private boolean hasRead;
    // 所有收件人
    private List<String> receivers;
    // 发送者信息
    private String sender;

//    public List<Message> getEmailMessageList() {
//        return emailMessageList;
//    }
//
//    public void setEmailMessageList(List<Message> emailMessageList) {
//        this.emailMessageList = emailMessageList;
//    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public List<String> getCcAddress() {
        return ccAddress;
    }

    public void setCcAddress(List<String> ccAddress) {
        this.ccAddress = ccAddress;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public List<File> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<File> attachmentList) {
        this.attachmentList = attachmentList;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isHasRead() {
        return hasRead;
    }

    public void setHasRead(boolean hasRead) {
        this.hasRead = hasRead;
    }

    public List<String> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<String> receivers) {
        this.receivers = receivers;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
