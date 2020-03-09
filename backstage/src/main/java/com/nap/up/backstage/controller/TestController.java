package com.nap.up.backstage.controller;

import com.nap.up.common.annotation.NoLogin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @creator napuping
 * @createTime 2020/2/27
 * @description
 */
@RestController
public class TestController {

    @GetMapping("/back/test")
    @NoLogin
    public String test() {
        return "世界你好-后台";
    }
}
