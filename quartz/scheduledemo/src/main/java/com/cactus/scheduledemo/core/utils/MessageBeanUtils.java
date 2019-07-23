package com.cactus.scheduledemo.core.utils;

import com.cactus.scheduledemo.core.bean.MessageBean;
import org.apache.commons.lang3.StringUtils;

/**
 * messagebean 工具类
 * Created by liruigao on 2019-07-23.
 */
public class MessageBeanUtils {

    public static MessageBean buildDataMessage(Object data, boolean isSuccess, String msg) {
        MessageBean messageBean = new MessageBean();
        messageBean.setData(data);
        messageBean.setMsg(msg);
        messageBean.setSuccess(isSuccess);
        return messageBean;
    }

    public static MessageBean buildDataMessage(Object data, boolean isSuccess) {
        MessageBean messageBean = new MessageBean();
        messageBean.setData(data);
        messageBean.setSuccess(isSuccess);
        return messageBean;
    }

    public static MessageBean buildDataMessage(Object data, boolean isSuccess, String msg, String code) {
        MessageBean messageBean = new MessageBean();
        messageBean.setData(data);
        messageBean.setMsg(msg);
        messageBean.setWidgetCode(code);
        messageBean.setSuccess(isSuccess);
        return messageBean;
    }

    public static MessageBean buildMessage(boolean isSuccess, String msg) {
        MessageBean messageBean = new MessageBean();
        messageBean.setSuccess(isSuccess);
        if (StringUtils.isNotBlank(msg)) {
            messageBean.setMsg(msg);
        }
        return messageBean;
    }

    public static MessageBean buildMessage(boolean isSuccess, String msg, String code) {
        MessageBean messageBean = new MessageBean();
        messageBean.setSuccess(isSuccess);
        if (StringUtils.isNotBlank(msg)) {
            messageBean.setMsg(msg);
        }
        messageBean.setCode(code);
        return messageBean;
    }

    public static MessageBean buildMessage(boolean isSuccess) {
        MessageBean messageBean = new MessageBean();
        messageBean.setSuccess(isSuccess);

        return messageBean;
    }

}