package com.cactus.reservationservice.controller;

import com.cactus.reservationservice.service.MqService;
import com.cactus.reservationservice.utils.RequestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RefreshScope
public class MessageController {

    @Value("${message}")
    private String msg;
    @Value("${mq.commonTopic}")
    private String commonTopic;

    @Autowired
    private MqService mqService;

    @RequestMapping(value = "/message")
    @ResponseBody
    public String getMsg() {
        return this.msg;
    }

    @RequestMapping(value = "/sendMsg", method = RequestMethod.POST)
    @ResponseBody
    public String sendMsg(HttpServletRequest request) {
        try {
            Map<String, Object> params = RequestUtils.convertRequest2Map(request);
            String msg = (String)params.get("msg");
            if (StringUtils.isBlank(msg)) {
                throw new Exception("msg is null");
            }
            mqService.sendMsg(msg, commonTopic);
            return "send msg success";
        } catch (Exception e) {
            e.printStackTrace();
            return "send msg error";
        }
    }
}
