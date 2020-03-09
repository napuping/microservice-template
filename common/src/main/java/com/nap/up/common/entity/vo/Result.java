package com.nap.up.common.entity.vo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

import static com.nap.up.common.enums.ResultCode.*;

/**
 * @creator napuping
 * @createTime 2020/3/7
 * @description
 */
@Data
public class Result {

    private int code;
    private Object data;
    private String message;
    private Map<String, Object> others;

    public Result(int code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static Result success() {
        return success(null);
    }

    public static Result success(String message) {
        return success(null, message);
    }

    public static Result success(Object data) {
        return success(data, SUCCESS.getMessage());
    }

    public static Result success(Object data, String message) {
        return success(SUCCESS.getCode(), data, message);
    }

    public static Result success(int code, Object data, String message) {
        return new Result(code, data, message);
    }

    public static Result fail(int code, Object data, String message) {
        return new Result(code, data, message);
    }

    public static Result fail(int code, Object data) {
        return fail(code, data, null);
    }

    public static Result fail(int code, String message) {
        return fail(code, null, message);
    }

    public static Result fail() {
        return fail(FAIL.getCode(), null, FAIL.getMessage());
    }

    public static Result fail(String message) {
        return fail(FAIL.getCode(), null, message);
    }

    public static Result unLogin() {
        return new Result(UN_LOGIN.getCode(), null, UN_LOGIN.getMessage());
    }

    public static Result build(int code, String message) {
        return build(code, null, message);
    }

    public static Result build(int code, Object data, String message) {
        return new Result(code, data, message);
    }

    //填充参数
    public Result fill(String name, Object value) {
        if (others == null) {
            others = new HashMap<>();
        }
        others.put(name, value);
        return this;
    }

}
