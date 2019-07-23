package com.cactus.scheduledemo.core.bean;

/**
 * 消息bean
 * Created by liruigao on 2019-07-23.
 */
public class MessageBean {

    // 是否成功
    private boolean success;
    // 返回状态码
    private String code;
    // 对应日志Id
    private String logId;
    // message
    private String msg;
    // widgetCode
    private String widgetCode;
    // 数据
    private Object data;
    // 时间戳
    private Long timestamp;

    public MessageBean(Object data) {
        this();
        this.data = data;
    }

    public MessageBean() {
        this.success = true;
        this.msg = "";
        this.timestamp = System.currentTimeMillis();
    }

    public MessageBean(boolean isSuccess, String msg) {
        this(isSuccess, msg, null);
    }

    public MessageBean(boolean isSuccess, String msg, Object data) {
        this();
        setSuccess(isSuccess);
        setMsg(msg);
        setData(data);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getWidgetCode() {
        return widgetCode;
    }

    public void setWidgetCode(String widgetCode) {
        this.widgetCode = widgetCode;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }
}
