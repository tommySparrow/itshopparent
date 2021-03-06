package com.it.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/20
 * @ Description：
 * @ throws
 */
@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * @methodDesc: 功能描述:(往redis添加信息)
     * @param: @param
     * key
     */
    public void setString(String key, String value) {
        set(key, value, null);
    }

    public void setString(String key, String value, Long timeOut) {
        set(key, value, timeOut);
    }

    public void set(String key, Object value, Long timeOut) {
        if (value != null) {

            if (value instanceof String) {
                String setValue = (String) value;
                stringRedisTemplate.opsForValue().set(key, setValue);
            }
            // 封装其他类型
            // 设置有效期
            if (timeOut != null) {
                stringRedisTemplate.expire(key, timeOut, TimeUnit.SECONDS);
            }
        }
    }

    /**
     * @methodDesc: 功能描述:(使用key 查找redis信息)
     * @param: @param
     * key
     */
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * @methodDesc: 功能描述:(使用key 删除redis信息)
     * @param: @param
     * key
     */
    public void delete(String key) {
        stringRedisTemplate.delete(key);
    }
}
