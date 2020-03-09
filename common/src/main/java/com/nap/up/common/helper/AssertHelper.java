package com.nap.up.common.helper;

import com.nap.up.common.exception.WebException;

/**
 * @creator napuping
 * @createTime 2020/3/8
 * @description
 */
public class AssertHelper {

    public static void notEmpty(Object object, String message) {
        if (object == null || "".equals(object)) {
            throw new WebException(message);
        }
    }

}
