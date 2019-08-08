package com.ucar.training.dao.impl;

import com.ucar.training.dao.RootUserDao;
import com.ucar.training.dao.UserDao;
import com.ucar.training.domain.RootUser;
import com.ucar.training.domain.User;

import java.util.HashSet;
import java.util.Set;

public class RootUserDaoImpl implements RootUserDao {
    private static Set<RootUser> roots = new HashSet<RootUser>();

    public static Set<RootUser> getRoots() {
        return roots;
    }

    public RootUserDaoImpl() {
        RootUser r = new RootUser("admin", "123");
        roots.add(r);
    }

    //超级用户注册
    @Override
    public int rootRegDao(RootUser root) {
        roots.add(root);
        return 1;
    }

    //根据超级用户名检查密码是否一致
    @Override
    public RootUser rootCheckPwdDao(String name, String pwd) {
        if (roots == null) {
            return null;
        }
        for (RootUser r : roots) {
            if (name.equals(r.getRuname())) {
                if (pwd.equals(r.getRpwd())) {
                    //用户名存在且密码正确,即登陆成功
                    return r;
                }
            }
        }
        return null;
    }

    //超级用户修改密码
    @Override
    public boolean rootChangePwdDao(String pwd) {
        return false;
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
