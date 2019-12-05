package com.cactus.demo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by liruigao
 * Date: 2019-12-05 15:45
 * Description:
 */

@Service
public class ScheduleDemo {
    @Scheduled(fixedDelay = 3000)
    public void taskOne() {
        System.out.println("taskOne - " + new Date());
    }

    @Scheduled(cron = "0 53 15 ? * *")
    public void taskTwo() {
        System.out.println("taskTwo - " + new Date());
    }
}
