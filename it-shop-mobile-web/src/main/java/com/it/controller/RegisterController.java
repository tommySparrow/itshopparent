package com.it.controller;

import com.it.entity.MbUser;
import com.it.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/30
 * @ Description：
 * @ throws
 */
@Controller
public class RegisterController {

    @Autowired
    private UserFeign userFeign;

    @RequestMapping("/register")
    public String register(@RequestBody MbUser mbUser){

        userFeign.save(mbUser);
        return "index";
    }
}
