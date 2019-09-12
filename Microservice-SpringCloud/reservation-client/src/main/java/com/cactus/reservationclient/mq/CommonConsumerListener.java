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

    // 为避免有异常被漏掉，将捕获级别设置为Throwable。（Exception与Error均继承于Throwable）
    // 进而保证listener成功返回CONSUME_SUCCESS状态，避免重复消费
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgList, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        try {
            System.out.println("start consume");
            for (MessageExt msgExt : msgList) {
                try {
                    String msg = new String(msgExt.getBody(), "utf-8");
                    Date date = new Date();
                    System.out.println(date + Thread.currentThread().getName() + " consume msg : " + msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
