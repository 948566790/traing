package com.ucar.training.service;

import com.ucar.training.domain.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    //注册用户
    public int userRegService(User user);


    //用户登陆检查
    public User userCheckPwdService(String name, String pwd);


    //用户修改密码
    public boolean userChangePwdService(String pwd);


    //根据用户名返回相应用户对象
    public User getUserInfoService(String name);

    //保存用户留言
    public void saveMsgService(String name, String msg);


    //根据用户名删除用户
    public void userDelService(String name);


    //修改用户信息
    public void userChangeService(User user);


    //删除留言
    public void msgDelService(String name, String date);


    //获取所有用户
    public List<User> getUSersService();
}
