package com.ucar.training.service;

import com.ucar.training.domain.RootUser;
import com.ucar.training.domain.User;

import java.util.Set;

public interface RootUserService {
    //注册超级用户
    public int rootRegService(RootUser root);


    //超级用户登陆检查
    public RootUser rootCheckPwdService(String name, String pwd);


    //超级用户修改密码
    public boolean rootChangePwdService(String pwd);


    //根据用户名删除用户
    public void userDelService(String name);


    //修改用户信息
    public void userChangeService(User user);


    //删除留言
    public void msgDelService(String name, String date);
}
