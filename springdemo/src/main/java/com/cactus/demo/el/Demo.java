package com.cactus.demo.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by liruigao
 * Date: 2019-10-11 20:52
 * Description:
 * 通过@Value注入内容
 */

@Component
public class Demo {
    @Value("乱七八糟其他的")
    public String another;

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }
}
