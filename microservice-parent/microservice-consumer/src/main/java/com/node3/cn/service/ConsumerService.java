package com.node3.cn.service;

import com.node3.cn.entity.TbUsers;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*以后调用microservicecloud-provider微服务中的方法，只需要调用下面对应的接口既可以了*/
@FeignClient(value="microservicecloud-provider", fallbackFactory=ConsumerServiceFallbackFactory.class)
public interface ConsumerService {

    /*调用接口中的get方法，即可以向microservicecloud-provider微服务发送/get/{id}请求*/
    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public TbUsers get(@PathVariable("id") long id);

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public boolean add(TbUsers user);

}
