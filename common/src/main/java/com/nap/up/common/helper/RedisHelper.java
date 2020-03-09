package com.nap.up.common.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @creator napuping
 * @createTime 2020/3/7
 * @description
 */
@Component
public class RedisHelper {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private ValueOperations<String, Object> valueOperations() {
        return redisTemplate.opsForValue();
    }

    public void valueSet(String key, Object value, long time) {
        valueSet(key, value, time, TimeUnit.SECONDS);
    }

    public void valueSet(String key, Object value, long time, TimeUnit timeUnit) {
        valueOperations().set(key, value, time, timeUnit);
    }

    public Object valueGet(String key) {
        return valueOperations().get(key);
    }

    private HashOperations<String, Object, Object> hashOperations() {
        return redisTemplate.opsForHash();
    }

    public void expire(String key, long time) {
        expire(key, time, TimeUnit.SECONDS);
    }

    public void expire(String key, long time, TimeUnit timeUnit) {
        redisTemplate.expire(key, time, timeUnit);
    }

    public void hashSet(String key, Object hashKey, Object value) {
        hashOperations().put(key, hashKey, value);
    }

    public Object hashGet(String key, Object hashKey) {
        return hashOperations().get(key, hashKey);
    }

}
