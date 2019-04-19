package com.it.service;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/demo")
public interface DemoApiService {

    @RequestMapping("/demo")
    Map<String,Object> demo();
}
