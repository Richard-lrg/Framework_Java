package com.cactus.demo.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by liruigao
 * Date: 2019-10-11 15:38
 * Description: AOP demo 配置类
 * @EnableAspectJAutoProxy 开启Spring对AspectJ的支持
 */

@Configuration
@ComponentScan("com.cactus.demo.aop")
@EnableAspectJAutoProxy
public class AopConfig {
}
