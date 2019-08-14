package com.ucar.training.service.impl;

import com.ucar.training.dao.MessageDao;
import com.ucar.training.dao.impl.MessageDaoImpl;
import com.ucar.training.domain.Message;
import com.ucar.training.service.MessageService;

import java.util.List;

public class MessageServiceImpl implements MessageService {
    MessageDao md = new MessageDaoImpl();

    @Override
    public void saveMsgService(String name, String msg) {
        md.saveMsgDao(name, msg);
    }

    @Override
    public void msgDelService(String name, String date) {
        md.msgDelDao(name, date);
    }

    @Override
    public List<Message> getAllMsgService() {

        return md.getAllMsgDao();
    }

    @Override
    public List<Message> getUserMsgService(String name) {
        return md.getUserMsgDao(name);
    }
}
