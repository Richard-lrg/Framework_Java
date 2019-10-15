package com.cactus.demo.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by liruigao
 * Date: 2019-10-11 20:42
 * Description:
 */


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
        BeanOne one1 = context.getBean(BeanOne.class);
        BeanOne one2 = context.getBean(BeanOne.class);
        BeanTwo two1 = context.getBean(BeanTwo.class);
        BeanTwo two2 = context.getBean(BeanTwo.class);
        System.out.println("Is one1 and one2 the same?  " + one1.equals(one2));
        System.out.println("Is two1 and two2 the same?  " + two1.equals(two2));
        context.close();
    }
}
