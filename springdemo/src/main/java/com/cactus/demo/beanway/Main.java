package com.cactus.demo.beanway;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by liruigao
 * Date: 2019-10-15 14:23
 * Description:
 */


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanWayConfig.class);
        BeanWayService beanWayService = context.getBean(BeanWayService.class);
        context.close();
    }
}
