package com.ucar.training.dao;

import com.ucar.training.domain.User;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserDao {
    //用户注册
    public int userRegDao(User user);


    //根据用户名检查密码是否一致
    public User userCheckPwdDao(String name, String pwd);


    //用户修改密码
    public boolean userChangePwdDao(String pwd);


    //根据用户名返回相应用户对象
    public User getUserInfoDao(String name);


    //根据用户名删除用户
    public void userDelDao(String name);


    //修改用户信息
    public void userChangeDao(User user);


    //删除用户留言
    public void msgDelDao(String name, String date);


    //返回所有用户信息
    public List<User> getUsersDao();

}
