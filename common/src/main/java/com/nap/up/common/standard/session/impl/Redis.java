package com.nap.up.common.standard.session.impl;

import com.alibaba.fastjson.JSON;
import com.nap.up.common.helper.EncryptHelper;
import com.nap.up.common.helper.RedisHelper;
import com.nap.up.common.helper.WebHelper;
import com.nap.up.common.standard.session.SessionAction;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static com.nap.up.common.standard.session.Constant.*;


/**
 * @creator napuping
 * @createTime 2020/3/3
 * @description
 */
public class Redis implements SessionAction {

    private RedisHelper redisHelper;

    public Redis(RedisHelper redisHelper) {
        this.redisHelper = redisHelper;
    }

    public String save(Object entity) {
        String token = createToken(entity);
        String tokenR = String.format("%s_%s", KEY, token);
        redisHelper.valueSet(tokenR, entity, LIVE_TIME);
        //写回客户端
        WebHelper.writeCookie(TOKEN_NAME,  token, LIVE_TIME);
        return token;
    }

    public <T> T get() {
        String token = getToken();
        return (T)redisHelper.valueGet(token);
    }

    public String getToken() {
        HttpServletRequest request = WebHelper.getRequest();
        String tokenH = request.getHeader(TOKEN_NAME);
        String tokenP = request.getParameter(TOKEN_NAME);
        String result = null;
        if (!StringUtils.isEmpty(tokenH)) {
            result = tokenH;
        }
        if (!StringUtils.isEmpty(tokenP)) {
            result = tokenP;
        }
        return KEY + "_" + result;
    }

    //得到token值
    private String createToken(Object entity) {
        String json = JSON.toJSONString(entity);
        String time = new Date().getTime() + "";
        return EncryptHelper.md5(json, time);
    }
}
