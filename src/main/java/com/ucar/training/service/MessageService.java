package com.ucar.training.service;

import com.ucar.training.domain.Message;

import java.util.List;

public interface MessageService {
    //保存用户留言
    public void saveMsgService(String name, String msg);


    //删除留言
    public void msgDelService(String name, String date);


    //获取所有留言
    public List<Message> getAllMsgService();


    //根据用户名返回留言
    public List<Message> getUserMsgService(String name);
}
