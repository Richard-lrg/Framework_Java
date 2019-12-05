package com.cactus.demo.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liruigao
 * Date: 2019-12-05 16:04
 * Description:
 */

@Configuration
public class ConditionalConifg {

    @Bean
    @Conditional(WindowsCondition.class)
    public IListService windowsListService() {
        return new WindowsListService();
    }

    @Bean
    @Conditional(MacCondition.class)
    public IListService macListService() {
        return new MacListService();
    }
}
