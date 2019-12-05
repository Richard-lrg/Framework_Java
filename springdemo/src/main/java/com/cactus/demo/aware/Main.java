package com.cactus.demo.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by liruigao
 * Date: 2019-12-05 14:45
 * Description:
 */


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareDemo awareDemo = context.getBean(AwareDemo.class);
        awareDemo.show();
        context.close();
    }
}
