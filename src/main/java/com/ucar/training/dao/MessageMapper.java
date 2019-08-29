package com.ucar.training.dao;

import com.ucar.training.domain.Message;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MessageMapper {
    //保存用户留言
    int saveMsg(String name, String msg);


    //删除用户留言
    int msgDel(String name, String date);


    //获取所有留言
    List<Message> getAllMsg();


    //根据用户名返回留言
    List<Message> getUserMsg(String name);
}
