package com.xiaokunliu.j2ee.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuth extends Authenticator {
    private String username;
    private String password;

    public MailAuth(String usr, String pwd) {
        this.username = usr;
        this.password = pwd;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }
}
