package com.nap.up.common.annotation;

import java.lang.annotation.*;

/**
 * @creator napuping
 * @createTime 2020/3/7
 * @description 抓取用户信息
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserFlag {
}
