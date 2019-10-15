package com.cactus.demo.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by liruigao
 * Date: 2019-10-15 14:50
 * Description:
 */


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublisher publisher = context.getBean(DemoPublisher.class);
        publisher.publish("hi honey~");
        context.close();
    }
}
