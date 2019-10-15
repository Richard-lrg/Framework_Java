package com.cactus.demo.iocdi;

import org.springframework.stereotype.Service;

/**
 * Created by liruigao
 * Date: 2019-10-11 11:02
 * Description:
 * 1. @Service 声明FuncOneService为bean
 */

@Service
public class FuncOneService {
    public String show(String word) {
        return "Function one show : " + word;
    }
}
