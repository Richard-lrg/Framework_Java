package com.cactus.scheduledemo.domain.enums;

/**
 * Created by liruigao on 2019-06-09.
 */
public enum JobStatusEnum {
    // 任务状态：正常运行
    RUN("run", 0),
    // 任务状态：停止运行
    STOP("stop", 1),
    // 操作状态：无操作
    NO_OPERATE("op_operate", 0),
    // 操作状态：启用job
    OP_RUNJOB("op_runjob", 1),
    // 操作状态：停用job
    OP_STOPJOB("op_stopjob", 2),
    // 操作状态：运行一次job
    OP_RUNONCE("op_runonce", 3),
    // 操作状态：中断任务
    OP_INTERRUPT("op_interrupt", 4);

    private String name;
    private Integer status;

    JobStatusEnum(String name, Integer status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
