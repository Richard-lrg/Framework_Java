package com.cactus.demo.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by liruigao
 * Date: 2019-10-15 14:45
 * Description:
 */

@Component
public class EventListener implements ApplicationListener<DemoEvent> {

    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg = demoEvent.getMsg();
        System.out.println("I had recived some msgs from publisher : " + msg);
    }
}
