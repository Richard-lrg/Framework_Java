package com.cactus.scheduledemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cactus.scheduledemo.core.bean.MessageBean;
import com.cactus.scheduledemo.core.bean.PageBean;
import com.cactus.scheduledemo.core.controller.BaseController;
import com.cactus.scheduledemo.core.helper.LoggerHelper;
import com.cactus.scheduledemo.core.utils.MessageBeanUtils;
import com.cactus.scheduledemo.core.utils.RequestUtils;
import com.cactus.scheduledemo.domain.entity.ScheduleApp;
import com.cactus.scheduledemo.domain.entity.ScheduleJob;
import com.cactus.scheduledemo.domain.vo.ScheduleJobLogVO;
import com.cactus.scheduledemo.domain.vo.ScheduleJobVO;
import com.cactus.scheduledemo.service.JobService;
import com.cactus.scheduledemo.service.ScheduleAppService;
import com.cactus.scheduledemo.service.ScheduleJobLogService;
import com.cactus.scheduledemo.service.ScheduleJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by liruigao on 2019-06-09.
 */
@Controller
public class JobController extends BaseController {
    @Autowired
    private JobService jobService;
    @Autowired
    private ScheduleAppService scheduleAppService;

    @Autowired
    private ScheduleJobService scheduleJobService;

    @Autowired
    private ScheduleJobLogService scheduleJobLogService;

    @RequestMapping(value = "/admin/application/list")
    @ResponseBody
    public MessageBean listApplication(HttpServletRequest request) {
        try {
            final Map<String, Object> params = RequestUtils.convertRequestToMap(request);
            String search = getString(params, "search");
            Integer pageNo = getInteger(params, "pageNo");
            Integer pageSize = getInteger(params, "pageSize");
            PageBean<ScheduleApp> appList = scheduleAppService.searchByPage(search, pageNo, pageSize);
            LoggerHelper.info(getClass(), "list application succes");
            return MessageBeanUtils.buildDataMessage(appList, true, "list application success");
        } catch (Exception e) {
            LoggerHelper.err(getClass(), "list job fail", e);
            return MessageBeanUtils.buildMessage(false, "list application success");
        }
    }

    @RequestMapping(value = "/admin/application/add", method = RequestMethod.POST)
    @ResponseBody
    public MessageBean addApplication(HttpServletRequest request) {
        try {
            Map<String, Object> params = RequestUtils.convertRequestToMap(request);
            String name = getString(params, "name");
            String appDesc = getString(params, "appDesc");
            String creator = getString(params, "userName");
            scheduleAppService.add(name, appDesc, creator);
            LoggerHelper.info(getClass(), "add application succes");
            return MessageBeanUtils.buildMessage(true, "add application success");
        } catch (Exception e) {
            LoggerHelper.err(getClass(), "add job fail", e);
            return MessageBeanUtils.buildMessage(false, "add application success");
        }
    }

    @RequestMapping(value = "/admin/application/update", method = RequestMethod.POST)
    @ResponseBody
    public MessageBean updateApplication(HttpServletRequest request) {
        try {
            Map<String, Object> params = RequestUtils.convertRequestToMap(request);
            Long id = getLong(params, "id");
            String name = getString(params, "name");
            String appDesc = getString(params, "appDesc");
            String updator = getString(params, "userName");
            scheduleAppService.update(id, name, appDesc, updator);
            LoggerHelper.info(getClass(), "update application succes");
            return MessageBeanUtils.buildMessage(true, "update application success");
        } catch (Exception e) {
            LoggerHelper.err(getClass(), "update job fail", e);
            return MessageBeanUtils.buildMessage(false, "update application success");
        }
    }

    @RequestMapping(value = "/admin/application/delete", method = RequestMethod.POST)
    @ResponseBody
    public MessageBean deleteApplication(HttpServletRequest request) {
        try {
            Map<String, Object> params = RequestUtils.convertRequestToMap(request);
            Long id = getLong(params, "id");
            scheduleAppService.delete(id);
            LoggerHelper.info(getClass(), "delete application succes");
            return MessageBeanUtils.buildMessage(true, "delete application success");
        } catch (Exception e) {
            LoggerHelper.err(getClass(), "delete job fail", e);
            return MessageBeanUtils.buildMessage(false, "delete application success");
        }
    }

    /**
     * job列表
     * @param request
     */
    @RequestMapping(value = "/admin/job/list")
    @ResponseBody
    public MessageBean listJob(HttpServletRequest request) {
        try {
            Map<String, Object> params = RequestUtils.convertRequestToMap(request);
            Long appId = getLong(params, "appId");
            String search = getString(params, "search");
            Integer pageNo = getInteger(params, "pageNo");
            Integer pageSize = getInteger(params, "pageSize");
            PageBean<ScheduleJobVO> jobPage = scheduleJobService.searchByPage(appId, search, pageNo, pageSize);
            LoggerHelper.info(getClass(), "list job success");
            return MessageBeanUtils.buildDataMessage(jobPage, true, "list job success");
        } catch (Exception e) {
            LoggerHelper.err(getClass(), "list job fail", e);
            return MessageBeanUtils.buildMessage(false, "list job fail");
        }
    }

    /**
     * 创建job
     * @param request
     */
    @RequestMapping(value = "/admin/job/save", method = RequestMethod.POST)
    @ResponseBody
    public MessageBean createJob(HttpServletRequest request) {
        try {
            Map<String, Object> params = RequestUtils.convertRequestToMap(request);
            Long appId = getLong(params, "appId");
            String jobName = getString(params, "jobName");
            String jobDesc = getString(params, "jobDesc");
            String jobCron = getString(params, "jobCron");
            Long jobStartTime = getLong(params, "jobStartTime");
            Long jobEndTime = getLong(params, "jobEndTime");
            String jobType = getString(params, "jobType");
            String jobParam = getString(params, "jobParam");
            Integer jobPriority = getInteger(params, "jobPriority");
            ScheduleJob job = new ScheduleJob(appId, jobName, jobDesc, jobCron, jobType, jobPriority,
                    jobParam, jobStartTime, jobEndTime);
            jobService.save(job);
            LoggerHelper.info(getClass(), "save job success");
            return MessageBeanUtils.buildMessage(true, "save job success");
        } catch (Exception e) {
            LoggerHelper.err(getClass(), "save job fail", e);
            return MessageBeanUtils.buildMessage(false, "save job fail");
        }
    }

    /**
     * 更新job
     * @param request
     */
    @RequestMapping(value = "/admin/job/update", method = RequestMethod.POST)
    @ResponseBody
    public MessageBean updateJob(HttpServletRequest request) {
        Map<String, Object> params = RequestUtils.convertRequestToMap(request);
        Long jobId = getLong(params, "jobId");
        try {
            Long appId = getLong(params, "appId");
            String jobName = getString(params, "jobName");
            String jobDesc = getString(params, "jobDesc");
            String jobCron = getString(params, "jobCron");
            Long jobStartTime = getLong(params, "jobStartTime");
            Long jobEndTime = getLong(params, "jobEndTime");
            String jobType = getString(params, "jobType");
            String jobParam = getString(params, "jobParam");
            Integer jobPriority = getInteger(params, "jobPriority");
            ScheduleJob job = new ScheduleJob(appId, jobName, jobDesc, jobCron, jobType, jobPriority,
                    jobParam, jobStartTime, jobEndTime);
            job.setJobId(jobId);
            jobService.update(job);
            LoggerHelper.info(getClass(), "update job success, jobId : {}", jobId);
            return MessageBeanUtils.buildMessage(true, "update job success");
        } catch (Exception e) {
            LoggerHelper.info(getClass(), "update job fail, jobId : {}", jobId, e);
            return MessageBeanUtils.buildMessage(false, "update job fail");
        }

    }

    /**
     * 恢复job
     * @param request
     */
    @RequestMapping(value = "/admin/job/resume", method = RequestMethod.POST)
    @ResponseBody
    public MessageBean resumeJob(HttpServletRequest request) {
        Map<String, Object> params = RequestUtils.convertRequestToMap(request);
        Long jobId = getLong(params, "jobId");
        try {
            jobService.resume(jobId);
            LoggerHelper.info(getClass(), "resume job success, jobId : {}", jobId);
            return MessageBeanUtils.buildMessage(true, "resume job success");
        } catch (Exception e) {
            LoggerHelper.info(getClass(), "resume job fail, jobId : {}", jobId, e);
            return MessageBeanUtils.buildMessage(false, "resume job fail");
        }
    }

    /**
     * 批量恢复job
     * @param request
     */
    @RequestMapping(value = "/admin/job/batchResume", method = RequestMethod.POST)
    @ResponseBody
    public MessageBean batchResumeJob(HttpServletRequest request) {
        try {
            Map<String, Object> params = RequestUtils.convertRequestToMap(request);
            String jobIds = getString(params, "jobIds");
            JSONArray jobIdArray = JSON.parseArray(jobIds);
            for (Object jobId : jobIdArray) {
                jobService.resume(Long.parseLong(String.valueOf(jobId)));
            }
            LoggerHelper.info(getClass(), "batch resume job success");
            return MessageBeanUtils.buildMessage(true, "batch resume job success");
        } catch (Exception e) {
            LoggerHelper.info(getClass(), "batch resume job fail", e);
            return MessageBeanUtils.buildMessage(false, "batch resume job fail");
        }
    }

    /**
     * 暂停job
     * @param request
     */
    @RequestMapping(value = "/admin/job/pause", method = RequestMethod.POST)
    @ResponseBody
    public MessageBean pauseJob(HttpServletRequest request) {
        Map<String, Object> params = RequestUtils.convertRequestToMap(request);
        Long jobId = getLong(params, "jobId");
        try {
            jobService.pause(jobId);
            LoggerHelper.info(getClass(), "pause job success, jobId : {}", jobId);
            return MessageBeanUtils.buildMessage(true, "pause job succes");
        } catch (Exception e) {
            LoggerHelper.info(getClass(), "pause job fail, jobId : {}", jobId, e);
            return MessageBeanUtils.buildMessage(false, "pause job fail");
        }
    }

    /**
     * 批量暂停job
     * @param request
     */
    @RequestMapping(value = "/admin/job/batchPause", method = RequestMethod.POST)
    @ResponseBody
    public MessageBean batchPauseJob(HttpServletRequest request) {
        try {
            Map<String, Object> params = RequestUtils.convertRequestToMap(request);
            String jobIds = getString(params, "jobIds");
            JSONArray jobIdArray = JSON.parseArray(jobIds);
            for (Object jobId : jobIdArray) {
                jobService.pause(Long.parseLong(String.valueOf(jobId)));
            }
            LoggerHelper.info(getClass(), "batch pause job success, jobId : {}");
            return MessageBeanUtils.buildMessage(true, "batch pause job succes");
        } catch (Exception e) {
            LoggerHelper.info(getClass(), "batch pause job fail", e);
            return MessageBeanUtils.buildMessage(false, "batch pause job fail");
        }
    }

    // 2019-07-15

    /**
     * 运行一次job
     * @param request
     */
    @RequestMapping(value = "/admin/job/run", method = RequestMethod.POST)
    @ResponseBody
    public MessageBean runJob(HttpServletRequest request) {
        Map<String, Object> params = RequestUtils.convertRequestToMap(request);
        Long jobId = getLong(params, "jobId");
        try {
            jobService.run(jobId);
            LoggerHelper.info(getClass(), "run once job success, jobId : {}", jobId);
            return MessageBeanUtils.buildMessage(true, "run once job success");
        } catch (Exception e) {
            LoggerHelper.info(getClass(), "run once job fail, jobId : {}", jobId, e);
            return MessageBeanUtils.buildMessage(false, "run once job fail");
        }
    }

    /**
     * 中断job
     * @param request
     */
    @RequestMapping(value = "/admin/job/interrupt", method = RequestMethod.POST)
    @ResponseBody
    public MessageBean interruptJob(HttpServletRequest request) {
        Map<String, Object> params = RequestUtils.convertRequestToMap(request);
        Long jobId = getLong(params, "jobId");
        try {
            jobService.interrupt(jobId);
            LoggerHelper.info(getClass(), "interrupt job success, jobId : {}", jobId);
            return MessageBeanUtils.buildMessage(true, "interrupt job success");
        } catch (Exception e) {
            LoggerHelper.info(getClass(), "interrupt job fail, jobId : {}", jobId, e);
            return MessageBeanUtils.buildMessage(false, "interrupt job fail");
        }
    }

    /**
     * 删除job
     * @param request
     */
    @RequestMapping(value = "/admin/job/delete", method = RequestMethod.POST)
    @ResponseBody
    public MessageBean deleteJob(HttpServletRequest request) {
        Map<String, Object> params = RequestUtils.convertRequestToMap(request);
        Long jobId = getLong(params, "jobId");
        try {
            jobService.delete(jobId);
            LoggerHelper.info(getClass(), "delete job success, jobId : {}", jobId);
            return MessageBeanUtils.buildMessage(true, "delete job success");
        } catch (Exception e) {
            LoggerHelper.info(getClass(), "delete job fail, jobId : {}", jobId, e);
            return MessageBeanUtils.buildMessage(false, "delete job fail");
        }
    }

    @RequestMapping(value = "/admin/jobLog/list")
    @ResponseBody
    public MessageBean listJobLog(HttpServletRequest request) {
        try {
            final Map<String, Object> params = RequestUtils.convertRequestToMap(request);
            String search = getString(params, "search");
            Integer pageNo = getInteger(params, "pageNo");
            Integer pageSize = getInteger(params, "pageSize");
            Integer status = getInteger(params, "status");
            PageBean<ScheduleJobLogVO> jobLogPage = scheduleJobLogService.list(search, status, pageNo, pageSize);
            LoggerHelper.info(getClass(), "list jobLog succes");
            return MessageBeanUtils.buildDataMessage(jobLogPage, true, "list jobLog success");
        } catch (Exception e) {
            LoggerHelper.err(getClass(), "list jobLog fail", e);
            return MessageBeanUtils.buildMessage(false, "list jobLog success");
        }
    }

    @RequestMapping(value = "/admin/jobLog/get")
    @ResponseBody
    public MessageBean getJobLog(HttpServletRequest request) {
        try {
            final Map<String, Object> params = RequestUtils.convertRequestToMap(request);
            Integer pageNo = getInteger(params, "pageNo");
            Integer pageSize = getInteger(params, "pageSize");
            Long jobId = getLong(params, "jobId");
            PageBean<ScheduleJobLogVO> jobLogPage = scheduleJobLogService.get(jobId, pageNo, pageSize);
            LoggerHelper.info(getClass(), "get jobLog succes");
            return MessageBeanUtils.buildDataMessage(jobLogPage, true, "get jobLog success");
        } catch (Exception e) {
            LoggerHelper.err(getClass(), "get jobLog fail", e);
            return MessageBeanUtils.buildMessage(false, "get jobLog success");
        }
    }

    /**
     * 重新执行job
     * @param request
     */
    @RequestMapping(value = "/admin/job/runAgain", method = RequestMethod.POST)
    @ResponseBody
    public MessageBean runAgainJob(HttpServletRequest request) {
        Map<String, Object> params = RequestUtils.convertRequestToMap(request);
        String jobParam = getString(params, "jobParam");
        Long jobId = getLong(params, "jobId");
        try {
            ScheduleJob job = scheduleJobService.get(jobId);
            job.setParams(jobParam);
            jobService.update(job);
            jobService.run(jobId);
            LoggerHelper.info(getClass(), "job run again success, jobId : {}", jobId);
            return MessageBeanUtils.buildMessage(true, "job run again success");
        } catch (Exception e) {
            LoggerHelper.info(getClass(), "job run again fail, jobId : {}", jobId, e);
            return MessageBeanUtils.buildMessage(false, "job run again fail");
        }

    }


}
