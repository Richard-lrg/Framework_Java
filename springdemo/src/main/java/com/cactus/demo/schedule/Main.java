package com.cactus.demo.schedule;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by liruigao
 * Date: 2019-12-05 15:49
 * Description:
 */


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScheduleConfig.class);
        ScheduleDemo scheduleDemo = context.getBean(ScheduleDemo.class);
    }
}
