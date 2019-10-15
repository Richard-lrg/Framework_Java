package com.cactus.demo.beanway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liruigao
 * Date: 2019-10-15 14:21
 * Description:
 */

@Configuration
@ComponentScan("com.cactus.demo.beanway")
public class BeanWayConfig {
    @Bean(initMethod = "init", destroyMethod = "destory")
    public BeanWayService getBeanWayService() {
        return new BeanWayService();
    }
}
