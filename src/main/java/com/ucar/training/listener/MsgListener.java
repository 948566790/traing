package com.ucar.training.listener;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @author jzm
 * @package com.ucar.training.listener
 * @date 2019/10/21 0021 11:21
 */

@Component
public class MsgListener implements javax.jms.MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            message.acknowledge();
            System.out.println("接收到消息"+ ((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
