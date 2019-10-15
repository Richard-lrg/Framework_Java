package com.cactus.demo.aop;

import org.springframework.stereotype.Service;

/**
 * Created by liruigao
 * Date: 2019-10-11 15:16
 * Description:
 *  被拦截类，使用拦截注解
 */

@Service
public class FuncOneService {

    @Action(name = "注解式拦截")
    public void show() {
        System.out.println("function one show time!");
    }
}
