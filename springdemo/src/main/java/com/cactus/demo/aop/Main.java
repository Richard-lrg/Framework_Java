package com.cactus.demo.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by liruigao
 * Date: 2019-10-11 15:37
 * Description:
 */


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        FuncOneService funcOneService = context.getBean(FuncOneService.class);
        FuncTwoService funcTwoService = context.getBean(FuncTwoService.class);
        // 注解式拦截
        funcOneService.show();
        // 方法规则式拦截
        funcTwoService.show();
        funcTwoService.test();

        context.close();
    }
}
