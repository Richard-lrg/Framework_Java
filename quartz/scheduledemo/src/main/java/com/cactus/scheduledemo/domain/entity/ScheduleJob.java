package com.cactus.scheduledemo.domain.entity;

import javax.persistence.*;

/**
 * Created by liruigao on 2019-06-09.
 */
@Entity
@Table(name = "schedule_job")
public class ScheduleJob {
    @Id
    @Column(name = "job_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    @Column(name = "app_id")
    private Long appId;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "status")
    private Integer status;

    @Column(name = "job_desc")
    private String jobDesc;

    @Column(name = "cron_expression")
    private String cronExpression;

    @Column(name = "job_type")
    private String jobType;

    @Column(name = "job_priority")
    private Integer jobPriority;

    @Column(name = "params")
    private String params;

    @Column(name = "start_time")
    private Long startTime;

    @Column(name = "end_time")
    private Long endTime;

    @Column(name = "create_time")
    private Long createTime;

    @Column(name = "update_time")
    private Long updateTime;

    public ScheduleJob() {
    }

    public ScheduleJob(Long appId, String jobName, String jobDesc, String cronExpression, String jobType,
                       Integer jobPriority, String params, Long startTime, Long endTime) {
        this.appId = appId;
        this.jobName = jobName;
        this.jobDesc = jobDesc;
        this.cronExpression = cronExpression;
        this.jobType = jobType;
        this.jobPriority = jobPriority;
        this.params = params;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Integer getJobPriority() {
        return jobPriority;
    }

    public void setJobPriority(Integer jobPriority) {
        this.jobPriority = jobPriority;
    }
}
