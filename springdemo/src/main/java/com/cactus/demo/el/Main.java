package com.cactus.demo.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by liruigao
 * Date: 2019-10-12 10:29
 * Description:
 */


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ELConfig.class);
        ELConfig elConfig = context.getBean(ELConfig.class);
        elConfig.output();
        context.close();
    }
}
