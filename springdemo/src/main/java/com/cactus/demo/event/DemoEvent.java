package com.cactus.demo.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by liruigao
 * Date: 2019-10-15 14:44
 * Description:
 */


public class DemoEvent extends ApplicationEvent {

    private String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
