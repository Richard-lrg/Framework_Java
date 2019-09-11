package com.cactus.reservationclient.mq;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * Created by liruigao
 * Date: 2019-09-11 15:47
 * Description: 消费监听器
 */

@Service
public class CommonConsumerListener implements MessageListenerConcurrently {
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgList, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        System.out.println("start consume");
        for (MessageExt msgExt : msgList) {
            try {
                String msg = new String(msgExt.getBody(), "utf-8");
                Date date = new Date();
                System.out.println(date + " consume msg : " + msg);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
