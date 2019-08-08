package com.ucar.training.service.impl;

import com.ucar.training.dao.impl.RootUserDaoImpl;
import com.ucar.training.domain.RootUser;
import com.ucar.training.domain.User;
import com.ucar.training.service.RootUserService;

import java.util.Set;

public class RootUserServiceImpl implements RootUserService {
    RootUserDaoImpl ru = new RootUserDaoImpl();

    //注册超级用户
    @Override
    public int rootRegService(RootUser root) {
        ru.rootRegDao(root);
        return 1;
    }

    //超级用户登陆检查
    @Override
    public RootUser rootCheckPwdService(String name, String pwd) {
        return ru.rootCheckPwdDao(name, pwd);
    }

    //超级用户修改密码
    @Override
    public boolean rootChangePwdService(String pwd) {
        return false;
    }


    //根据用户名删除用户
    @Override
    public void userDelService(String name) {
        ru.userDelDao(name);
        return;
    }

    //修改用户信息
    @Override
    public void userChangeService(User user) {
        ru.userChangeDao(user);
        return;
    }

    //删除留言
    @Override
    public void msgDelService(String name, String date) {
        ru.msgDelDao(name, date);
        return;
    }
}
