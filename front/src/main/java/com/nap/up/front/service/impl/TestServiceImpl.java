package com.nap.up.front.service.impl;

import com.github.pagehelper.PageInfo;
import com.nap.up.common.entity.param.PageParam;
import com.nap.up.common.helper.PageHelper;
import com.nap.up.entity.User;
import com.nap.up.front.service.TestService;
import com.nap.up.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @creator napuping
 * @createTime 2020/3/9
 * @description
 */
@Component
public class TestServiceImpl implements TestService {

    @Autowired
    private UserRepository userRepository;

    public PageInfo<User> getUsers(PageParam pageParam) {
        List<User> all = userRepository.findAll();
        System.out.println(all);
        pageParam.setPageNum(1);
        pageParam.setPageSize(3);
        PageInfo<User> pageInfo = PageHelper.jpaStart(pageParam.getPageNum(),
                pageParam.getPageSize(), userRepository, (root, cb) -> {
                    List<Predicate> predicates = new ArrayList<>();
                    predicates.add(cb.equal(root.get("id"), "1"));
                    return predicates;
                });
        return pageInfo;
    }
}
