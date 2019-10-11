package com.cactus.javaconfigdemo;

/**
 * Created by liruigao
 * Date: 2019-10-11 11:33
 * Description: 普通方法类，不声明为Bean
 */


public class FuncOneService {
    public String show(String word) {
        return "java config, Function one show : " + word;
    }
}
