package com.it.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/demo")
public interface DemoApiService {

    /**
     * @ Description 测试demo
     */
    @RequestMapping("/demo")
    Map<String, Object> demo();
    /**
     * @ Description 测试Redis存储
     */
    @GetMapping("/setKey")
    Map<String, Object> setKey(String key, String value);
    /**
     * @ Description 测试Redis获取
     */
    @GetMapping("/getKey")
    Map<String, Object> getKey(String key);
}
