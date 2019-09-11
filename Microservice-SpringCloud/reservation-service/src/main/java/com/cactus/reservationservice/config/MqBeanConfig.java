package com.cactus.reservationservice.config;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.MQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liruigao
 * Date: 2019-09-03 11:46
 * Description: rocketmq 配置类
 */
@Configuration
public class MqBeanConfig {
    @Value("${mq.namesrvAddr}")
    private String namesrvAddr;

    private static final String PRODUCER_GROUP = "cactus_producer_group";

    @Bean(name = "commonProducer", destroyMethod = "shutdown")
    public MQProducer mqProducer() throws MQClientException {
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer(PRODUCER_GROUP);
        defaultMQProducer.setNamesrvAddr(namesrvAddr);
        defaultMQProducer.setInstanceName("cactus_produer");
        defaultMQProducer.setVipChannelEnabled(false);
        defaultMQProducer.setMaxMessageSize(Integer.MAX_VALUE);
        defaultMQProducer.start();
        System.out.println("start commonProducer");
        Runtime.getRuntime().addShutdownHook( new Thread(new Runnable() {
            @Override
            public void run() {
                defaultMQProducer.shutdown();
            }
        }));
        return defaultMQProducer;
    }

}
