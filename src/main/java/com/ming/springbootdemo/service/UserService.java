package com.ming.springbootdemo.service;

import com.ming.springbootdemo.pojo.User;

public interface UserService {
    /**
     * 根据用户名查找用户
     *
     * @param name 用户名
     * @return 用户对象
     */
    User selUserByNameService(String name);

    /**
     * 检查用户名与密码是否匹配
     *
     * @param name 用户名
     * @param pwd  密码
     * @return 用户对象
     */
    User checkPwdService(String name, String pwd);
}
