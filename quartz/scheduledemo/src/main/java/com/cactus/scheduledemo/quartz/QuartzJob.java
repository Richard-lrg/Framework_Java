package com.cactus.scheduledemo.quartz;

import com.alibaba.fastjson.JSON;
import com.cactus.scheduledemo.core.constant.Constants;
import com.cactus.scheduledemo.core.helper.LoggerHelper;
import com.cactus.scheduledemo.core.utils.SpringContextUtils;
import com.cactus.scheduledemo.domain.entity.ScheduleJob;
import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;

import java.io.Serializable;

/**
 * Created by liruigao on 2019-06-09.
 */
public class QuartzJob implements InterruptableJob, Serializable {

    private static final long serialVersionUID = 1L;
    private transient JobExecutor jobExecutor;

    @Override
    public void execute(JobExecutionContext context) {
        String jsonJob = context.getMergedJobDataMap().getString(Constants.JOB_PARAM_KEY);
        ScheduleJob job = JSON.parseObject(jsonJob, ScheduleJob.class);
        jobExecutor = SpringContextUtils.getBean("jobExecutor", JobExecutor.class);
        LoggerHelper.info(getClass(), " start execute job, jobType : {}", job.getJobType());
        jobExecutor.execute(job);
    }

    @Override
    public void interrupt() {
        jobExecutor.interrupt();
    }
}
