package com.cactus.scheduledemo;

import com.cactus.scheduledemo.service.ScheduleJobService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTests {
    @Autowired
    private ScheduleJobService scheduleJobService;

}
