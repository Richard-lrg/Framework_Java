package com.cactus.demo.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by liruigao
 * Date: 2019-12-05 16:02
 * Description:
 */


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionalConifg.class);
        IListService listService = context.getBean(IListService.class);
        listService.list();
        context.close();
    }
}
