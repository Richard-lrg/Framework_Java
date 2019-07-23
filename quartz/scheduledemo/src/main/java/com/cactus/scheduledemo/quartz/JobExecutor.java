package com.cactus.scheduledemo.quartz;

import com.cactus.scheduledemo.core.helper.LoggerHelper;
import com.cactus.scheduledemo.core.utils.SpringContextUtils;
import com.cactus.scheduledemo.domain.entity.ScheduleJob;
import com.cactus.scheduledemo.domain.entity.ScheduleJobLog;
import com.cactus.scheduledemo.domain.enums.JobEnum;
import com.cactus.scheduledemo.service.ScheduleJobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liruigao on 2019-07-18.
 */
@Service("jobExecutor")
public class JobExecutor implements Serializable {

    private static final long serialVersionUID = 1L;
    private transient JobRunable jobRunable;
    @Autowired
    private ScheduleJobLogService scheduleJobLogService;

    private static Long jobLogId;
    private static Map<String, Class<? extends JobRunable>> jobTypeMap =
            new HashMap<>();

    private void init(ScheduleJob job) {
        // 遍历添加所有任务类
        for (JobEnum jobEnum : JobEnum.values()) {
            jobTypeMap.put(jobEnum.getJobType(), jobEnum.getJobClass());
        }
        // 初始化任务执行log
        LoggerHelper.info(getClass(), "job start, jobId : {}", job.getJobId());
        Long startTime = System.currentTimeMillis();
        ScheduleJobLog jobLog = new ScheduleJobLog(job.getJobId(), job.getJobName(), job.getJobType(),
                job.getParams(), 0, startTime, "job run log: \n");
        jobLogId = scheduleJobLogService.save(jobLog);
    }

    public void execute(ScheduleJob job) {
        jobRunable = SpringContextUtils.getBean(job.getJobType(), jobTypeMap.get(job.getJobType()));
        try {
            init(job);
            jobRunable.run(job.getParams(), jobLogId);
            scheduleJobLogService.finish(jobLogId);
        } catch (Exception e) {
            scheduleJobLogService.errorEnd(jobLogId, e.getMessage());
            LoggerHelper.err(getClass(), "job run error, jobId : {}", job.getJobId(), e);
        }
    }

    public void interrupt() {
        if (null != jobRunable) {
            jobRunable.interrupt();
        }
    }


}
