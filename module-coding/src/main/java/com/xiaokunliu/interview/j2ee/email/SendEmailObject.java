package com.xiaokunliu.interview.j2ee.email;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * project:java-code
 * file:SendEmail
 * package:com.xiaokunliu.j2ee.email
 * date:2019/7/30 5:39 PM
 * author:keithl
 */
public class SendEmailObject implements Serializable {

    private String to;              // receiver
    private String from;            // sender
    private String smtpServerHost;      // server host
    private String smtpUserName;
    private String smtpPassword;

    private String subject;     // topic
    private String content;
    private List<String> attachments = new ArrayList<>();

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSmtpServerHost() {
        return smtpServerHost;
    }

    public void setSmtpServerHost(String smtpServerHost) {
        this.smtpServerHost = smtpServerHost;
    }

    public String getSmtpUserName() {
        return smtpUserName;
    }

    public void setSmtpUserName(String smtpUserName) {
        this.smtpUserName = smtpUserName;
    }

    public String getSmtpPassword() {
        return smtpPassword;
    }

    public void setSmtpPassword(String smtpPassword) {
        this.smtpPassword = smtpPassword;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachment) {
        this.attachments.add(attachment);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("to", to)
                .append("from", from)
                .append("smtpServerHost", smtpServerHost)
                .append("smtpUserName", smtpUserName)
                .append("smtpPassword", smtpPassword)
                .append("subject", subject)
                .append("content", content)
                .append("attachments", attachments)
                .toString();
    }
}
