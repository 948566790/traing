package com.ucar.training.dao.impl;

import com.ucar.training.dao.UserDao;
import com.ucar.training.domain.User;

import java.util.*;

public class UserDaoImpl implements UserDao {
    private static Set<User> users = new HashSet<User>();

    public static Set<User> getUsers() {
        return users;
    }

    //注册用户
    @Override
    public int userRegDao(User user) {
        users.add(user);
        return 1;
    }

    //检查用户密码
    @Override
    public User userCheckPwdDao(String name, String pwd) {
        if (users == null) {
            return null;
        }
        for (User u : users) {
            if (name.equals(u.getUname())) {
                if (pwd.equals(u.getPwd())) {
                    //用户名存在且密码正确,即登陆成功
                    return u;
                }
            }
        }
        return null;
    }

    //用户修改密码
    @Override
    public boolean userChangePwdDao(String pwd) {
        return false;
    }


    ////根据用户名返回相应用户对象
    @Override
    public User getUserInfoDao(String name) {
        for (User u : users) {
            if (name.equals(u.getUname())) {
                return u;
            }
        }
        return null;
    }

    //根据用户名删除用户
    @Override
    public void userDelDao(String name) {
        Set<User> uers = UserDaoImpl.getUsers();
        for (User u : uers) {
            if (name.equals(u.getUname())) {
                UserDaoImpl.getUsers().remove(u);
                return;
            }
        }
    }

    //根据用户名修改用户信息
    @Override
    public void userChangeDao(User user) {
        if (user == null) {
            return;
        }
        for (User u : UserDaoImpl.getUsers()) {
            if (user.getUname().equals(u.getUname())) {
                UserDaoImpl.getUsers().remove(u);
                UserDaoImpl.getUsers().add(user);
                return;
            }
        }

    }

    //删除用户留言
    @Override
    public void msgDelDao(String name, String date) {
        for (User u : UserDaoImpl.getUsers()) {
            if (name.equals(u.getUname())) {
                //查看是否存在该留言
                if (u.getMessage().containsKey(date)) {
                    //删除该留言
                    u.getMessage().remove(date);
                }
            }
        }
    }
}
