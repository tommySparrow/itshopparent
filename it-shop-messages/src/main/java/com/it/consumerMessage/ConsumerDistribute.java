package com.it.consumerMessage;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：jmyang
 * @ Date       ：Created in 2019/4/24
 * @ Description：消费MQ消息
 * @ throws
 */
@Component
@Slf4j
public class ConsumerDistribute {

    @JmsListener(destination = "mail_queue")
    public void distribute(String json){

        log.info("###消息服务###收到消息,消息内容 json:{}", json);
        if (StringUtils.isEmpty(json)) {
            return;
        }
        JSONObject jsonObject = new JSONObject().parseObject(json);
        JSONObject header = jsonObject.getJSONObject("header");
        String interfaceType = header.getString("interfaceType");
        System.out.println(interfaceType);

        JSONObject content = jsonObject.getJSONObject("content");
        String userName = content.getString("userName");
        System.out.println(userName);
    }
}
