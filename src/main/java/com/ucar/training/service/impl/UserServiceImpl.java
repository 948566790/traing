package com.ucar.training.service.impl;


import com.ucar.training.controller.LoginServlet;
import com.ucar.training.dao.impl.UserDaoImpl;
import com.ucar.training.domain.User;
import com.ucar.training.service.UserService;


import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoImpl ud = new UserDaoImpl();


    //用户注册
    @Override
    public int userRegService(User user) {
        ud.userRegDao(user);
        return 1;
    }

    //用户登陆检查
    @Override
    public User userCheckPwdService(String name, String pwd) {

        return ud.userCheckPwdDao(name, pwd);
    }


    //用户修改密码
    @Override
    public boolean userChangePwdService(String pwd) {
        return false;
    }


    //根据用户名返回相应用户对象
    @Override
    public User getUserInfoService(String name) {
        return ud.getUserInfoDao(name);
    }


    //保存留言
    @Override
    public void saveMsgService(String name, String msg) {
        User user = getUserInfoService(name);
        user.getMessage().put(LoginServlet.formatDate(new Date()), msg);
        userChangeService(user);
        return;
    }

    //根据用户名删除用户
    @Override
    public void userDelService(String name) {
        ud.userDelDao(name);
        return;
    }

    //修改用户信息
    @Override
    public void userChangeService(User user) {
        ud.userChangeDao(user);
        return;
    }

    //删除留言
    @Override
    public void msgDelService(String name, String date) {
        ud.msgDelDao(name, date);
        return;
    }

    //获取所有用户

    @Override
    public List<User> getUSersService() {
        return ud.getUsersDao();
    }
}
