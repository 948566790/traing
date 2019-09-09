package com.ming.springbootdemo.service.impl;

import com.ming.springbootdemo.dao.UserMapper;
import com.ming.springbootdemo.pojo.User;
import com.ming.springbootdemo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User selUserByNameService(String name) {
        return userMapper.selUserByName(name);
    }

    @Override
    public User checkPwdService(String name, String pwd) {
        return userMapper.checkPwd(name, pwd);
    }
}
