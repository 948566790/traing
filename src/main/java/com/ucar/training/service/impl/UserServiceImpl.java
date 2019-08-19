package com.ucar.training.service.impl;


import com.ucar.training.domain.User;
import com.ucar.training.dao.UserMapper;
import com.ucar.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class UserServiceImpl implements UserService {
    //UserDaoImpl ud = new UserDaoImpl();
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    //用户注册
    @Override
    public int userRegService(User user) {
        userMapper.userReg(user);
        return 1;
    }

    //用户登陆检查
    @Override
    public User userCheckPwdService(String name, String pwd) {

        return userMapper.userCheckPwd(name, pwd);
    }


    //用户修改密码
    @Override
    public boolean userChangePwdService(String pwd) {
        return false;
    }


    //根据用户名返回相应用户对象
    @Override
    public User getUserInfoService(String name) {
        return userMapper.getUserInfo(name);
    }



    //根据用户名删除用户
    @Override
    public void userDelService(String name) {
        userMapper.userDel(name);
        return;
    }

    //修改用户信息
    @Override
    public void userChangeService(User user) {
        userMapper.userChange(user);
        return;
    }


    //获取所有用户
    @Override
    public List<User> getUSersService() {
        return userMapper.getUsers();
    }
}
