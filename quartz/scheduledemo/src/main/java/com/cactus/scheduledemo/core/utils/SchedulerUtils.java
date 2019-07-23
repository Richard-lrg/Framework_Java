package com.cactus.scheduledemo.core.utils;

import com.alibaba.fastjson.JSON;
import com.cactus.scheduledemo.core.constant.Constants;
import com.cactus.scheduledemo.domain.entity.ScheduleJob;
import com.cactus.scheduledemo.quartz.QuartzJob;
import org.quartz.*;

import java.util.Date;


/**
 * Created by liruigao on 2019-06-09.
 *
 * 定时任务工具类
 */
public class SchedulerUtils {

    public static void createJob(Scheduler scheduler, ScheduleJob scheduleJob) throws Exception {
        Long jobId = scheduleJob.getJobId();

        // 创建Job对象
        JobDetail job = JobBuilder.newJob(QuartzJob.class).withIdentity("JOB_" + jobId).build();

        // 创建触发器
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression())
                .withMisfireHandlingInstructionDoNothing();
        // 错过的任务不会再弥补执行
        cronScheduleBuilder.withMisfireHandlingInstructionDoNothing();
        Trigger trigger = null;
        if (null != scheduleJob.getStartTime() && null != scheduleJob.getEndTime()) {
            trigger = TriggerBuilder.newTrigger()
                    .withIdentity("TRIGGER_" + jobId)
                    .startAt(new Date(scheduleJob.getStartTime()))
                    .endAt(new Date(scheduleJob.getEndTime()))
                    .withSchedule(cronScheduleBuilder)
                    .build();
        } else if (null != scheduleJob.getStartTime() && null == scheduleJob.getEndTime()) {
            trigger = TriggerBuilder.newTrigger()
                    .withIdentity("TRIGGER_" + jobId)
                    .startAt(new Date(scheduleJob.getStartTime()))
                    .withSchedule(cronScheduleBuilder)
                    .build();
        } else {
            trigger = TriggerBuilder.newTrigger()
                    .withIdentity("TRIGGER_" + jobId)
                    .withSchedule(cronScheduleBuilder)
                    .build();
        }
        // 添加上下文内容
        job.getJobDataMap().put(Constants.JOB_PARAM_KEY, JSON.toJSONString(scheduleJob));
        // 添加job，并暂停
        scheduler.scheduleJob(job, trigger);
        scheduler.pauseJob(JobKey.jobKey("JOB_" + jobId));
    }

    public static void updateJob(Scheduler scheduler, ScheduleJob scheduleJob) throws Exception {
        deleteJob(scheduler, scheduleJob.getJobId());
        createJob(scheduler, scheduleJob);
    }

    public static void resumeJob(Scheduler scheduler, Long jobId) throws Exception {
        scheduler.resumeJob(JobKey.jobKey("JOB_" + jobId));
    }

    public static void pauseJob(Scheduler scheduler, Long jobId) throws Exception {
        scheduler.pauseJob(JobKey.jobKey("JOB_" + jobId));
    }

    public static void run(Scheduler scheduler, Long jobId) throws Exception {
        JobKey jobKey = JobKey.jobKey("JOB_" + jobId);
        scheduler.triggerJob(jobKey);
    }

    public static void interruptJob(Scheduler scheduler, Long jobId) throws Exception {
        scheduler.interrupt(JobKey.jobKey("JOB_" + jobId));
    }
    public static void deleteJob(Scheduler scheduler, Long jobId) throws Exception {
        TriggerKey triggerKey = TriggerKey.triggerKey("JOB_" + jobId);
        // 停止触发器
        scheduler.pauseTrigger(triggerKey);
        // 移除触发器
        scheduler.unscheduleJob(triggerKey);
        // 删除任务
        scheduler.deleteJob(JobKey.jobKey("JOB_" + jobId));
    }

}
