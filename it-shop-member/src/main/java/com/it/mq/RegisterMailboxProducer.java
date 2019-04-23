package com.it.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/23
 * @ Description：
 * @ throws
 */
@Service
public class RegisterMailboxProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void send(Destination destination,String json){

        jmsMessagingTemplate.convertAndSend(destination,json);
    }
}
