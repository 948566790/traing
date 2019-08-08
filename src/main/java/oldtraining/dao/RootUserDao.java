package oldtraining.dao;

import oldtraining.domain.RootUser;
import oldtraining.domain.User;

public interface RootUserDao {
    //超级用户注册
    public int rootRegDao(RootUser root);


    //根据超级用户名检查密码是否一致
    public RootUser rootCheckPwdDao(String name, String pwd);


    //超级用户修改密码
    public boolean rootChangePwdDao(String pwd);


    //根据用户名删除用户
    public void userDelDao(String name);


    //修改用户信息
    public void userChangeDao(User user);


    //删除用户留言
    public void msgDelDao(String name, String date);


}
