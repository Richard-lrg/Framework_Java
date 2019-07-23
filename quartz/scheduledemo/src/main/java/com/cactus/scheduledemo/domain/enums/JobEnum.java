package com.cactus.scheduledemo.domain.enums;


import com.cactus.scheduledemo.quartz.JobRunable;
import com.cactus.scheduledemo.quartz.runable.CycleRunable;
import com.cactus.scheduledemo.quartz.runable.TestRunable;

/**
 * Created by liruigao on 2019-07-18.
 */
public enum JobEnum {
    TEST_JOB("test", TestRunable.class),
    CYCLE_JOB("cycle", CycleRunable.class);

    private String jobType;
    private Class<? extends JobRunable> jobClass;

    JobEnum(String jobType, Class<? extends JobRunable> jobClass) {
        this.jobType = jobType;
        this.jobClass = jobClass;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Class<? extends JobRunable> getJobClass() {
        return jobClass;
    }

    public void setJobClass(Class<? extends JobRunable> jobClass) {
        this.jobClass = jobClass;
    }
}
