package com.node3.cn.dao;

import com.node3.cn.entity.TbRolesMenusKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbRolesMenusDao {
    int deleteByPrimaryKey(TbRolesMenusKey key);

    int insert(TbRolesMenusKey record);

    int insertSelective(TbRolesMenusKey record);
}