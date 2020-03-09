package com.nap.up.common.standard.session;

/**
 * @creator napuping
 * @createTime 2020/3/7
 * @description
 */
public interface Constant {

    //用户token存活时长 60*60*24*30 秒
    int LIVE_TIME = 60*60*24*30;
    //token前缀
    String KEY = "np_user";
    //前端访问携带token参数名称
    String TOKEN_NAME = "x-access-token";

}
