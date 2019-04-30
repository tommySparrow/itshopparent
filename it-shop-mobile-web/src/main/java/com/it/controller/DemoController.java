package com.it.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/30
 * @ Description：
 * @ throws
 */
@RestController
public class DemoController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
