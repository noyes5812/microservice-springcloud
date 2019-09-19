package com.node3.cn.dao;

import com.node3.cn.entity.TbUsers;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbUsersDao {
    int deleteByPrimaryKey(Long uid);

    int insert(TbUsers record);

    int insertSelective(TbUsers record);

    TbUsers selectByPrimaryKey(Long uid);

    int updateByPrimaryKeySelective(TbUsers record);

    int updateByPrimaryKey(TbUsers record);
}