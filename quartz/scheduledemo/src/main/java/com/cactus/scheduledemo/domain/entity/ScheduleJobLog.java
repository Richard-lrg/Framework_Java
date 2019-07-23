package com.cactus.scheduledemo.domain.entity;

import javax.persistence.*;

/**
 * Created by liruigao on 2019-07-16.
 */
@Entity
@Table(name = "schedule_job_log")
public class ScheduleJobLog {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_id")
    private Long jobId;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "job_type")
    private String jobType;

    @Column(name = "params")
    private String params;

    @Column(name = "status")
    private Integer status;

    @Column(name = "start_time")
    private Long startTime;

    @Column(name = "end_time")
    private Long endTime;

    @Column(name = "job_log")
    private String jobLog;

    @Column(name = "create_time")
    private Long createTime;

    public ScheduleJobLog() {
    }

    public ScheduleJobLog(Long jobId, String jobName, String jobType, String params, Integer status,
                          Long startTime, String jobLog) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobType = jobType;
        this.params = params;
        this.status = status;
        this.startTime = startTime;
        this.jobLog = jobLog;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getJobLog() {
        return jobLog;
    }

    public void setJobLog(String jobLog) {
        this.jobLog = jobLog;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
}

