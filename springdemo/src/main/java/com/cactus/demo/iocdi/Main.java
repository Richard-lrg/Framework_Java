package com.cactus.demo.iocdi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by liruigao
 * Date: 2019-10-11 11:05
 * Description:
 */


public class Main {
    public static void main(String[] args) {
        // 使用AnnotationConfigApplicationContext容器，并选择BeanConfig为配置类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        // bean已有容器创建，从容器中获取方法bean
        FuncTwoService funcTwoService = context.getBean(FuncTwoService.class);

        String showWord = funcTwoService.show("hi ioc&di");

        System.out.println(showWord);

        context.close();

    }
}
