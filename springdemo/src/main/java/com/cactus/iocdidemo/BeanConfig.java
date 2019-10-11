package com.cactus.iocdidemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liruigao
 * Date: 2019-10-11 11:07
 * Description:
 * 1. @Configuration 声明注册类
 * 2. @ComponentScan扫描指定包，并注册为Bean
 */

@Configuration
@ComponentScan("com.cactus.iocdidemo")
public class BeanConfig {
}
