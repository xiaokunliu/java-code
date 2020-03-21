package com.xiaokunliu.interview.j2ee.email;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * project:java-code
 * file:ReceiveEmailObject
 * package:com.xiaokunliu.j2ee.email
 * date:2019/7/30 6:13 PM
 * author:keithl
 */
public class ReceiveEmailConfig implements Serializable {

    public final static String POP3_SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

    private String pop3Account;
    private String pop3Password;
    private String pop3Host;
    private int pop3Port;

    public String getPop3Account() {
        return pop3Account;
    }

    public void setPop3Account(String pop3Account) {
        this.pop3Account = pop3Account;
    }

    public String getPop3Password() {
        return pop3Password;
    }

    public void setPop3Password(String pop3Password) {
        this.pop3Password = pop3Password;
    }

    public String getPop3Host() {
        return pop3Host;
    }

    public void setPop3Host(String pop3Host) {
        this.pop3Host = pop3Host;
    }

    public int getPop3Port() {
        return pop3Port;
    }

    public void setPop3Port(int pop3Port) {
        this.pop3Port = pop3Port;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("pop3Account", pop3Account)
                .append("pop3Password", pop3Password)
                .append("pop3Host", pop3Host)
                .append("pop3Port", pop3Port)
                .toString();
    }
}
