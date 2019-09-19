package com.node3.cn.service;

import com.node3.cn.entity.TbUsers;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*以后调用microservicecloud-provider微服务中的方法，只需要调用下面对应的接口既可以了*/
@FeignClient(value="microservicecloud-provider")
public interface TbUsersService {
    int deleteByPrimaryKey(Long uid);

    int insert(TbUsers record);

    int insertSelective(TbUsers record);

    TbUsers selectByPrimaryKey(Long uid);

    int updateByPrimaryKeySelective(TbUsers record);

    int updateByPrimaryKey(TbUsers record);
}
