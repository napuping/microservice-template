package com.nap.up.common.handler;

import com.nap.up.common.entity.vo.Result;
import com.nap.up.common.exception.WebException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @creator napuping
 * @createTime 2020/3/6
 * @description
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(WebException.class)
    public Result handleWebException(WebException e) {
        if (e.getCode() != null) {
            return Result.fail(e.getCode(), e.getMessage());
        }
        return Result.fail(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        return Result.fail(e.getMessage());
    }

}
