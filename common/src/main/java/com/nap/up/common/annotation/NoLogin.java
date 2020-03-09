package com.nap.up.common.annotation;

import java.lang.annotation.*;

/**
 * @creator napuping
 * @createTime 2020/3/7
 * @description
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoLogin {
}
