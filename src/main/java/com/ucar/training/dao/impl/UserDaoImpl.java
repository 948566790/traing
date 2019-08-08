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
}
