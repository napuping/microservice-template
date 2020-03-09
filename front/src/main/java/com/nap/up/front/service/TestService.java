package com.nap.up.front.service;

import com.github.pagehelper.PageInfo;
import com.nap.up.common.entity.param.PageParam;
import com.nap.up.entity.User;

/**
 * @creator napuping
 * @createTime 2020/3/9
 * @description
 */
public interface TestService {

    PageInfo<User> getUsers(PageParam pageParam);

}
