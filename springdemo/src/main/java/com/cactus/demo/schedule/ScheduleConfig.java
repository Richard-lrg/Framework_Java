package com.cactus.demo.schedule;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by liruigao
 * Date: 2019-12-05 15:48
 * Description:
 */

@Configuration
@ComponentScan("com.cactus.demo.schedule")
@EnableScheduling
public class ScheduleConfig {
}
