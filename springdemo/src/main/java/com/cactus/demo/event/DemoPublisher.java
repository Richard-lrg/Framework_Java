package com.cactus.demo.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by liruigao
 * Date: 2019-10-15 14:48
 * Description:
 */

@Component
public class DemoPublisher {
    @Autowired
    private ApplicationContext applicationContext;

    public void publish(String msg) {
        applicationContext.publishEvent(new DemoEvent(this, msg));
    }
}
