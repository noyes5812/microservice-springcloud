package com.node3.cn.dao;

import com.node3.cn.entity.TbAdmin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbAdminDao {
    int deleteByPrimaryKey(Long id);

    int insert(TbAdmin record);

    int insertSelective(TbAdmin record);

    TbAdmin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbAdmin record);

    int updateByPrimaryKey(TbAdmin record);
}