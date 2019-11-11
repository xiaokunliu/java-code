package com.xiaokunliu.datastruct;

/**
 * Created by keithl on 2017/10/29.
 */

public class DataStructException extends RuntimeException{

    public DataStructException() {
    }

    public DataStructException(String message) {
        super(message);
    }

    public DataStructException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataStructException(Throwable cause) {
        super(cause);
    }

    public DataStructException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
