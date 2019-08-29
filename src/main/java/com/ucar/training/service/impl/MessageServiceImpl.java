package com.ucar.training.service.impl;

import com.ucar.training.dao.MessageMapper;
import com.ucar.training.domain.Message;
import com.ucar.training.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    MessageMapper messageMapper;

    @Override
    public void saveMsgService(String name, String msg) {
        messageMapper.saveMsg(name, msg);
    }

    @Override
    public void msgDelService(String name, String date) {
        messageMapper.msgDel(name, date);
    }

    @Override
    public List<Message> getAllMsgService() {

        return messageMapper.getAllMsg();
    }

    @Override
    public List<Message> getUserMsgService(String name) {
        return messageMapper.getUserMsg(name);
    }

}
