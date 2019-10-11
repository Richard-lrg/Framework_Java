package com.cactus.javaconfigdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by liruigao
 * Date: 2019-10-11 11:43
 * Description:
 */


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        FuncTwoService funcTwoService = context.getBean(FuncTwoService.class);

        System.out.println(funcTwoService.show("hi javaConfig"));

        context.close();
    }
}
