package com.cactus.demo.aop;

import org.springframework.stereotype.Service;

/**
 * Created by liruigao
 * Date: 2019-10-11 15:42
 * Description:
 * 被拦截类， 使用方法规则拦截
 */

@Service
public class FuncTwoService {
    public void show() {
        System.out.println("this is func2 showtime");
    }

    public void test() {
        System.out.println("this is func2 showtime test");
    }
}
