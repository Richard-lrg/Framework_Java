package com.cactus.reservationservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RefreshScope
public class MessageController {

    @Value("${message}")
    private String msg;

    @RequestMapping(value = "/message")
    @ResponseBody
    public String getMsg() {
        return this.msg;
    }
}
