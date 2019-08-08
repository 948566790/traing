package oldtraining.service.impl;


import oldtraining.controller.LoginServlet;
import oldtraining.dao.impl.UserDaoImpl;
import oldtraining.domain.User;
import oldtraining.service.UserService;

import java.util.Date;

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
        RootUserServiceImpl rus = new RootUserServiceImpl();
        rus.userChangeService(user);
        return;
    }
}
