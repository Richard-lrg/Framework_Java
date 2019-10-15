package com.cactus.demo.iocdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liruigao
 * Date: 2019-10-11 11:03
 * Description:
 * 1. @Service 声明 FuncTwoService 为bean
 * 2. @Autowired 将 FuncOneService 注入到 FuncTwoService
 */

@Service
public class FuncTwoService {
    @Autowired
    private FuncOneService funcOneService;

    public String show(String word) {
        return funcOneService.show(word);
    }
}
