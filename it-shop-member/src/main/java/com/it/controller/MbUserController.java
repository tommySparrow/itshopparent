package com.it.controller;

import com.it.entity.MbUser;
import com.it.response.BaseApiService;
import com.it.serviceImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/20
 * @ Description：
 * @ throws
 */
@RestController
public class MbUserController extends BaseApiService {

    @Autowired
    private UserService userService;

    @RequestMapping("/insert")
    public Map<String,Object> save(){

        MbUser mbUser = new MbUser();
        mbUser.setUserName("jack").setPassword("123456").setCreated(new Date());
        userService.save(mbUser);

        return setResultSuccess();
    }
}
