package com.nap.up.common.enums;

/**
 * @creator napuping
 * @createTime 2020/3/7
 * @description
 */
public enum ResultCode {
    SUCCESS(200, "操作成功"),
    FAIL(400, "操作失败"),
    UN_LOGIN(401, "未登录或登录已过期")
    ;
    private int code;
    private String message;
    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
