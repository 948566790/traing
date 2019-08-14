package com.ucar.training.dao;

import com.ucar.training.domain.Message;

import java.util.List;

public interface MessageDao {
    //保存用户留言
    public void saveMsgDao(String name, String msg);


    //删除用户留言
    public void msgDelDao(String name, String date);


    //获取所有留言
    public List<Message> getAllMsgDao();


    //根据用户名返回留言
    public List<Message> getUserMsgDao(String name);
}
