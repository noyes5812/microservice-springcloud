package com.node3.cn.service.impl;

import com.node3.cn.dao.TbUsersDao;
import com.node3.cn.entity.TbUsers;
import com.node3.cn.service.TbUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbUsersServiceImpl implements TbUsersService {

    @Autowired
    TbUsersDao tbUsersDao;

    @Override
    public int deleteByPrimaryKey(Long uid) {
        return tbUsersDao.deleteByPrimaryKey(uid);
    }

    @Override
    public int insert(TbUsers record) {
        return tbUsersDao.insert(record);
    }

    @Override
    public int insertSelective(TbUsers record) {
        return tbUsersDao.insertSelective(record);
    }

    @Override
    public TbUsers selectByPrimaryKey(Long uid) {
        return tbUsersDao.selectByPrimaryKey(uid);
    }

    @Override
    public int updateByPrimaryKeySelective(TbUsers record) {
        return tbUsersDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TbUsers record) {
        return tbUsersDao.updateByPrimaryKey(record);
    }
}
