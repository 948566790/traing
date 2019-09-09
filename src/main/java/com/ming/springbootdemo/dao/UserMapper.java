package com.ming.springbootdemo.dao;

import com.ming.springbootdemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 根据用户名查找用户
     *
     * @param name 用户名
     * @return 用户对象
     */
    User selUserByName(String name);

    /**
     * 检查用户名与密码是否匹配
     *
     * @param name 用户名
     * @param pwd  密码
     * @return 用户对象
     */
    User checkPwd(String name, String pwd);
}
