package com.cactus.demo.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by liruigao
 * Date: 2019-12-05 15:28
 * Description:
 */

@Service
public class AsyncDemo {
    public void funcOne(Integer i) {
        System.out.println("funcOne : " + i);
    }

    @Async
    public void funcTwo(Integer i) {
        try {
            Thread.sleep(50 - i);
            System.out.println("funcTwo : " + i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
