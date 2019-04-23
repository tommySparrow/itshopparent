package com.it.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.it.constans.MQInterfaceType;
import com.it.entity.MbUser;
import com.it.mapper.MbUserMapper;
import com.it.mq.RegisterMailboxProducer;
import com.it.response.BaseApiService;
import com.it.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import java.util.Map;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/20
 * @ Description：
 * @ throws
 */
@Slf4j
@RestController
public class UserServiceImpl extends BaseApiService implements UserService {

    @Autowired
    private MbUserMapper mbUserMapper;
    @Autowired
    private RegisterMailboxProducer registerMailboxProducer;//发送信息到MQ
    @Value("${messages.queue}")
    private String MESSAGES_QUEUE;
    @Override
    public Map<String, Object> save(@RequestBody MbUser mbUser){
        mbUserMapper.insert(mbUser);

        String userName = mbUser.getUserName();
        String email = mbUser.getEmail();
        //对列
        Destination activeMQQueue = new ActiveMQQueue(MESSAGES_QUEUE);
        registerMailboxProducer.send(activeMQQueue,mailMessage(email,userName));//发送消息到MQ
        return setResultSuccessData(mbUser);
    }

    private String mailMessage(String email, String userName) {
        JSONObject root = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("interfaceType", MQInterfaceType.SMS_MAIL);
        JSONObject content = new JSONObject();
        content.put("mail", email);
        content.put("userName", userName);
        root.put("header", header);
        root.put("content", content);
        return root.toJSONString();
    }
}
