package com.it.serviceImpl;

import com.it.response.BaseApiService;
import com.it.service.DemoApiService;
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

    @Override
    public Map<String, Object> demo() {

        return setResultSuccess();//成功返回
    }
}
