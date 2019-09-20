package com.node3.cn.controller;

import com.node3.cn.entity.TbUsers;
import com.node3.cn.service.ConsumerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TbUserConsumerController {
    //    private static String REST_URL_PREFIX = "http://localhost:8002";
//    @Autowired
//    private RestTemplate restTemplate;
    private Logger logger = Logger.getLogger(getClass());
    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(value = "/consumer/add")
    public boolean addUser(TbUsers user) {
        //Boolean flag = restTemplate.postForObject(REST_URL_PREFIX + "/add", user, Boolean.class);
        Boolean flag =consumerService.add(user);
        return flag;
    }

    @RequestMapping(value = "/consumer/get/{id}")
    public TbUsers get(@PathVariable("id") long id) {
        logger.error("id="+id);

        //TbUsers user = restTemplate.getForObject(REST_URL_PREFIX + "/get" + "/" + id, TbUsers.class);
        TbUsers user = consumerService.get(id);
        return user;
    }
}
