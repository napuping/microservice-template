package com.nap.up.common.helper;

import com.nap.up.common.enums.ResultCode;
import com.nap.up.common.exception.WebException;
import org.springframework.util.StringUtils;

/**
 * @creator napuping
 * @createTime 2020/3/19
 * @description
 */
public class BusinessAssert {

    //是否符合异常条件
    private static boolean checkCondition(Object obj) {
        if (StringUtils.isEmpty(obj)) {
            return true;
        }
        if (obj instanceof Integer && (Integer)obj == 0) {
            return true;
        }
        return false;
    }

    //任何一个为空则跑一场
    public static void notEmpty(String message, Object... objs) {
        if (objs == null || objs.length == 0) {
            return;
        }
        for (Object tmp : objs) {
            if (checkCondition(tmp)) {
                throwException(message);
            }
        }
    }
    //跑一场
    public static void throwException(String message) {
        message = StringUtils.isEmpty(message) ? "处理异常" : message;
        throw new WebException(ResultCode.FAIL.getCode(), message);
    }
}
