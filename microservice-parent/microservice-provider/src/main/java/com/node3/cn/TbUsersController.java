package com.node3.cn;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.node3.cn.entity.TbUsers;
import com.node3.cn.service.TbUsersService;
import com.node3.cn.web.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class TbUsersController  extends BaseController {

    private Logger logger = Logger.getLogger(TbUsersController.class);
    @Autowired
    TbUsersService tbUsersService;

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public boolean addUser(@RequestBody TbUsers user){
        int flag = tbUsersService.insertSelective(user);
        if(flag>0){
            return  true;
        }else{
            return false;
        }
    }
    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    @HystrixCommand(fallbackMethod="hystrixGetUser") //一旦服务调用失败，就调用hystrixGetUser方法
    public TbUsers getUser(@PathVariable("id") long id){
        TbUsers user = tbUsersService.selectByPrimaryKey(id);
        if(user==null){
            throw new RuntimeException("不存在id=" + id + "对应的用户信息");
        }
        return user;
    }

    public TbUsers hystrixGetUser(@PathVariable("id") long id){
        TbUsers users=new TbUsers(id,"用户不存在");
       return users;
    }
}
