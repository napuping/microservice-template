package com.nap.up.common.standard.session;

/**
 * @creator napuping
 * @createTime 2020/3/3
 * @description
 */
public interface SessionAction {

    String save(Object entity);

    <T> T get();

    default String getToken() { return null; };
}
