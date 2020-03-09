package com.nap.up.front.controller;

import com.nap.up.common.annotation.NoLogin;
import com.nap.up.common.annotation.UserFlag;
import com.nap.up.common.entity.param.PageParam;
import com.nap.up.common.entity.vo.Result;
import com.nap.up.common.standard.session.SessionDirector;
import com.nap.up.front.entity.vo.Test;
import com.nap.up.front.service.TestService;
import com.nap.up.repository.PdUserRepository;
import com.nap.up.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @creator napuping
 * @createTime 2020/3/2
 * @description
 */
@Api(tags = "test")
@RestController
public class TestController {

    @Autowired
    private SessionDirector sessionDirector;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PdUserRepository pdUserRepository;

    @Autowired
    private TestService testService;

    @ApiOperation("测试接口")
    @GetMapping("test")
    @NoLogin
    public Result test(@UserFlag Test s) {
//        Test t = new Test();
//        t.setName("sa");
//        sessionDirector.save(t);
//        Test test = sessionDirector.get();
//        System.out.print(test);
//        System.out.print(userRepository.findAll());
//        System.out.println(pdUserRepository.findAll());
        return Result.success(testService.getUsers(new PageParam())).fill("33", "世界你好");
    }


}
