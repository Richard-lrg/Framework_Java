package com.cactus.scheduledemo.domain.vo;

/**
 * Created by liruigao on 2019-07-12.
 */
public class ScheduleJobVO {
    private Long jobId;

    private String jobName;

    private String status;

    private String jobDesc;

    private String jobCron;

    private String jobType;

    private Integer jobPriority;

    private String params;

    private String createTime;

    public ScheduleJobVO() {
    }

    public ScheduleJobVO(Long jobId, String jobName, String status, String jobDesc, String jobCron,
                         String jobType, Integer jobPriority, String params, String createTime) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.status = status;
        this.jobDesc = jobDesc;
        this.jobCron = jobCron;
        this.jobType = jobType;
        this.jobPriority = jobPriority;
        this.params = params;
        this.createTime = createTime;
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

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getJobCron() {
        return jobCron;
    }

    public void setJobCron(String jobCron) {
        this.jobCron = jobCron;
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

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
