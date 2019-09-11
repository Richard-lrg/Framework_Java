package com.cactus.reservationservice.service;

import com.alibaba.rocketmq.client.producer.MQProducer;
import com.alibaba.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by liruigao
 * Date: 2019-09-11 14:45
 * Description: rocketmq 方法类
 */

@Service
public class MqService {
    @Autowired
    @Qualifier("commonProducer")
    private MQProducer mqProducer;

    public void sendMsg(String msg, String topic) {
        try {
            mqProducer.send(new Message(topic, "tag1st", msg.getBytes("utf-8")));
            System.out.println(new Date() + " message send success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 需设置重试机制，以及重试失败后的消息降级策略
    }

}
