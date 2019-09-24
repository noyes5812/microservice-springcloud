package com.node3.cn.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TestController {
    @GetMapping("/test")
    //@RequiresAuthentication
    public String test() throws Exception{
        if (1==1){
            throw  new Exception("异常");
        }
        return "success";
    }

    @GetMapping("/test1")
    //@RequiresAuthentication
    public String test1() throws Exception{

        return "success";
    }

}
