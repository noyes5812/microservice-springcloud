package com.node3.cn.dao;

import com.node3.cn.entity.TbRoles;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbRolesDao {
    int deleteByPrimaryKey(Long roleId);

    int insert(TbRoles record);

    int insertSelective(TbRoles record);

    TbRoles selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(TbRoles record);

    int updateByPrimaryKey(TbRoles record);
}