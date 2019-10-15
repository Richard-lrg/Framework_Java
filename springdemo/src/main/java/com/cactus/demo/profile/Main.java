package com.cactus.demo.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by liruigao
 * Date: 2019-10-15 14:34
 * Description:
 */


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prod");
        // 需要后置注册配置类，否则会报error
        context.register(ProfileConfig.class);
        context.refresh();
        DemoBean bean = context.getBean(DemoBean.class);
        System.out.println(bean.getContent());
        context.close();
    }
}
