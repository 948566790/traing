package oldtraining.dao;

import oldtraining.domain.User;

public interface UserDao {
    //用户注册
    public int userRegDao(User user);


    //根据用户名检查密码是否一致
    public User userCheckPwdDao(String name, String pwd);


    //用户修改密码
    public boolean userChangePwdDao(String pwd);


    //根据用户名返回相应用户对象
    public User getUserInfoDao(String name);

}
