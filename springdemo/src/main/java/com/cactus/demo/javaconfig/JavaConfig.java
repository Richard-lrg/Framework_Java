package com.cactus.demo.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liruigao
 * Date: 2019-10-11 11:36
 * Description:
 * 1. 声明为配置类
 * 2. 无需进行包扫描，因为所有的bean都在这里定义
 * 3. 通过使用@Bean注解， 可以更加灵活地创建管理Bean
 */

@Configuration
public class JavaConfig {

    @Bean
    public FuncOneService funcOneService() {
        return new FuncOneService();
    }

    @Bean
    public FuncTwoService funcTwoService() {
        FuncTwoService funcTwoService = new FuncTwoService();
        funcTwoService.setFuncOneService(funcOneService());
        return funcTwoService;
    }
}
