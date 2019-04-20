package com.it.serviceImpl;

import com.it.entity.MbUser;
import com.it.mapper.MbUserMapper;
import com.it.response.BaseApiService;
import com.it.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/20
 * @ Description：
 * @ throws
 */
@Slf4j
@RestController
public class UserServiceImpl extends BaseApiService implements UserService {

    @Autowired
    private MbUserMapper mbUserMapper;

    @Override
    public Map<String, Object> save(@RequestBody MbUser mbUser){
        mbUserMapper.insert(mbUser);
        return setResultSuccessData(mbUser);
    }
}
