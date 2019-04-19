package com.it.serviceImpl;

import com.it.service.DemoApiService;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/19
 * @ Description：实现类
 * @ throws
 */
@RestController
public class DemoApiServiceImpl implements DemoApiService {

    @Override
    public Map<String, Object> demo() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","success");
        return map;
    }
}
