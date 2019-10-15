package com.cactus.demo.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by liruigao
 * Date: 2019-10-15 14:32
 * Description:
 */

@Configuration
public class ProfileConfig {
    @Bean
    @Profile("dev")
    public DemoBean getDemoBeanDev() {
        return new DemoBean("this is dev env");
    }

    @Bean
    @Profile("prod")
    public DemoBean getDemoBeanProd() {
        return new DemoBean("this is prod env");
    }
}
