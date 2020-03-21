package com.xiaokunliu.interview.web.infrastructure.web;

/**
 * date:2019/11/28 10:36
 * author:keithl
 * desc: business desc etc.
 */
public class WebException extends RuntimeException {

    public WebException() {
    }

    public WebException(String message) {
        super(message);
    }

    public WebException(String message, Throwable cause) {
        super(message, cause);
    }

    public WebException(Throwable cause) {
        super(cause);
    }

    public WebException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
