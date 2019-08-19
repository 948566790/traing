package com.ucar.training.dao;

import com.ucar.training.domain.User;

import java.util.List;

public interface UserMapper {
    //用户注册
    int userReg(User user);


    //根据用户名检查密码是否一致
    User userCheckPwd(String name, String pwd);


    //用户修改密码
    int userChangePwd(String pwd);


    //根据用户名返回相应用户对象
    User getUserInfo(String name);


    //根据用户名删除用户
    int userDel(String name);


    //修改用户信息
    int userChange(User user);


    //返回所有用户信息
    List<User> getUsers();

}
