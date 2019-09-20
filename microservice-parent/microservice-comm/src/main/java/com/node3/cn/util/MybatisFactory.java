package com.node3.cn.util;

import java.io.IOException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.NestedIOException;

public class MybatisFactory extends SqlSessionFactoryBean {

    @Override
    protected SqlSessionFactory buildSqlSessionFactory() throws IOException {
        try{
            return super.buildSqlSessionFactory();
        }catch(NestedIOException e){
            e.printStackTrace();
            throw new NestedIOException("Failed to parse mapping resource:",e.getCause());
        }
    }
}
