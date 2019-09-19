package com.node3.cn.service;

import com.node3.cn.entity.TbUsers;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ConsumerServiceFallbackFactory implements FallbackFactory<ConsumerService> {
    @Override
    public ConsumerService create(Throwable throwable) {
        return new ConsumerService() {
            @Override
            public TbUsers get(long id) {
                TbUsers user = new TbUsers(id, "该用户不存在");
                return user;
            }

            @Override
            public boolean add(TbUsers user) {
                return false;
            }
        };
    }
}
