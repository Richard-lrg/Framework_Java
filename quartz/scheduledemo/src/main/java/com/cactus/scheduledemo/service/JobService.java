package com.cactus.scheduledemo.service;

import com.cactus.scheduledemo.core.utils.SchedulerUtils;
import com.cactus.scheduledemo.domain.entity.ScheduleJob;
import com.cactus.scheduledemo.domain.enums.JobStatusEnum;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by liruigao on 2019-06-09.
 */
@Service
public class JobService {
    @Autowired
    private Scheduler scheduler;
    @Autowired
    private ScheduleJobService scheduleJobService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(ScheduleJob scheduleJob) throws Exception {
        scheduleJob.setCreateTime(System.currentTimeMillis());
        scheduleJob.setUpdateTime(System.currentTimeMillis());
        scheduleJob.setStatus(JobStatusEnum.STOP.getStatus());
        scheduleJob = scheduleJobService.save(scheduleJob);
        SchedulerUtils.createJob(scheduler, scheduleJob);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void resume(Long jobId) throws Exception {
        scheduleJobService.updateStatus(jobId, JobStatusEnum.RUN.getStatus());
        SchedulerUtils.resumeJob(scheduler, jobId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void pause(Long jobId) throws Exception {
        scheduleJobService.updateStatus(jobId, JobStatusEnum.STOP.getStatus());
        SchedulerUtils.pauseJob(scheduler, jobId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void run(Long jobId) throws Exception {
        // 仅执行一次
        SchedulerUtils.run(scheduler, jobId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void update(ScheduleJob scheduleJob) throws Exception {
        scheduleJob.setUpdateTime(System.currentTimeMillis());
        scheduleJob.setStatus(JobStatusEnum.STOP.getStatus());
        scheduleJobService.update(scheduleJob);
        SchedulerUtils.updateJob(scheduler, scheduleJob);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void interrupt(Long jobId) throws Exception {
        SchedulerUtils.interruptJob(scheduler, jobId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Long jobId) throws Exception {
        scheduleJobService.delete(jobId);
        SchedulerUtils.deleteJob(scheduler, jobId);
    }
}
