package com.cactus.scheduledemo.domain.vo;

/**
 * Created by liruigao on 2019-07-16.
 */
public class ScheduleJobLogVO {
    private Long id;

    private Long jobId;

    private String jobName;

    private String status;

    private String jobType;

    private String startTime;

    private String params;

    private String endTime;

    private String jobLog;

    public ScheduleJobLogVO() {
    }

    public ScheduleJobLogVO(Long id, Long jobId, String jobName, String jobType, String params, String jobLog) {
        this.id = id;
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobType = jobType;
        this.params = params;
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

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getJobLog() {
        return jobLog;
    }

    public void setJobLog(String jobLog) {
        this.jobLog = jobLog;
    }
}
