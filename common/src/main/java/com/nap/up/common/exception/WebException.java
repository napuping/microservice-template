package com.nap.up.common.exception;

/**
 * @creator napuping
 * @createTime 2020/3/7
 * @description
 */
public class WebException extends RuntimeException {

    private Integer code;

    public WebException() {
        super();
    }

    public WebException(String message) {
        super(message);
    }

    public WebException(int code, String message) {
        this(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
