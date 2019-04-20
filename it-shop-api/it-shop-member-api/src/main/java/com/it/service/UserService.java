package com.it.service;

import com.it.entity.MbUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/20
 * @ Description：
 * @ throws
 */
@RequestMapping("/member")
public interface UserService {

    @PostMapping("/insert")
    Map<String, Object> save(MbUser mbUser);
}
