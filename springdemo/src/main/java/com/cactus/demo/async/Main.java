package com.cactus.demo.async;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by liruigao
 * Date: 2019-12-05 15:30
 * Description:
 */


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AsyncConfig.class);
        AsyncDemo asyncDemo = context.getBean(AsyncDemo.class);
        for (int i = 0; i < 50; i++) {
            asyncDemo.funcOne(i);
        }
        for (int i = 0; i < 50; i++) {
            asyncDemo.funcTwo(i);
        }
        context.close();
    }
}
