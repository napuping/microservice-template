package com.nap.up.common.standard.session;

import com.nap.up.common.helper.RedisHelper;
import com.nap.up.common.standard.session.impl.Redis;
import com.nap.up.common.standard.session.impl.Session;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @creator napuping
 * @createTime 2020/3/3
 * @description
 */
@Component
public class SessionDirector implements SessionAction, InitializingBean {

    @Autowired
    private SessionConfig sessionConfig;
    @Autowired
    private RedisHelper redisHelper;

    private SessionAction sessionAction;

    public String save(Object entity) {
        return sessionAction.save(entity);
    }

    public <T> T get() {
        return sessionAction.get();
    }

    public void afterPropertiesSet() throws Exception {
        //判断使用哪种缓存
        SessionType type = SessionType.judge(sessionConfig.getType());
        switch (type) {
            case REDIS:
                buildRedis();
                break;
            case SESSION:
                buildSession();
                break;
        }
    }
    private void buildRedis() {
        sessionAction = new Redis(redisHelper);
    }
    private void buildSession() {
        sessionAction = new Session();
    }
}
