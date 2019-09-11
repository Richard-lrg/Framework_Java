package com.cactus.reservationclient.config;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.MQConsumer;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;
import com.cactus.reservationclient.mq.CommonConsumerListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liruigao
 * Date: 2019-09-11 15:39
 * Description:
 */

@Configuration
public class MqConfig {
    @Value("${mq.namesrvAddr}")
    private String namesrvAddr;

    @Value("${mq.commonTopic}")
    private String commonTopic;

    private static final String CONSUMER_GROUP = "cactus_consumer_group";

    @Bean(name = "commonConsumer", destroyMethod = "shutdown")
    public MQConsumer mqConsumer(CommonConsumerListener commonConsumerListener) throws MQClientException {
        DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer(CONSUMER_GROUP);
        defaultMQPushConsumer.setNamesrvAddr(namesrvAddr);
        defaultMQPushConsumer.subscribe(commonTopic, "*");
        defaultMQPushConsumer.registerMessageListener(commonConsumerListener);
        defaultMQPushConsumer.setConsumeMessageBatchMaxSize(64);
        defaultMQPushConsumer.setPullBatchSize(64);

        defaultMQPushConsumer.setConsumeThreadMax(4);
        defaultMQPushConsumer.setConsumeThreadMin(4);
        defaultMQPushConsumer.setInstanceName("cactus_consumer");
        defaultMQPushConsumer.setPullInterval(100L);
        defaultMQPushConsumer.setMessageModel(MessageModel.CLUSTERING);
        defaultMQPushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

        defaultMQPushConsumer.start();
        System.out.println("mqConsumer start!");

        Runtime.getRuntime().addShutdownHook( new Thread(new Runnable() {
            @Override
            public void run() {
                defaultMQPushConsumer.shutdown();
            }
        }));
        return defaultMQPushConsumer;
    }

}
