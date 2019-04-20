package com.it.serviceImpl;

import com.it.redis.RedisUtil;
import com.it.response.BaseApiService;
import com.it.service.DemoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/19
 * @ Description：实现类
 * @ throws
 */
@RestController
public class DemoApiServiceImpl extends BaseApiService implements DemoApiService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Map<String, Object> demo() {

        return setResultSuccess();//成功返回
    }

    @Override
    public Map<String, Object> setKey(String key, String value) {
        redisUtil.setString(key, value);
        return setResultSuccess();
    }

    @Override
    public Map<String, Object> getKey(String key) {
        String str = redisUtil.get(key);
        return setResultSuccessData(str);
    }
}
