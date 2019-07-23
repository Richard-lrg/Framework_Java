package com.cactus.scheduledemo.service;

import com.cactus.scheduledemo.core.bean.PageBean;
import com.cactus.scheduledemo.core.helper.LoggerHelper;
import com.cactus.scheduledemo.core.utils.DateUtils;
import com.cactus.scheduledemo.dao.IScheduleJobLogDAO;
import com.cactus.scheduledemo.domain.entity.ScheduleJobLog;
import com.cactus.scheduledemo.domain.vo.ScheduleJobLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liruigao on 2019-07-16.
 */
@Service("scheduleJobLogService")
public class ScheduleJobLogService {
    @Autowired
    private IScheduleJobLogDAO scheduleJobLogDAO;

    public Long save(ScheduleJobLog jobLog) {
        jobLog.setCreateTime(System.currentTimeMillis());
        return scheduleJobLogDAO.save(jobLog).getId();
    }

    public void update(ScheduleJobLog jobLog) {
        scheduleJobLogDAO.saveAndFlush(jobLog);
    }

    public PageBean<ScheduleJobLogVO> list(String search, Integer status, Integer pageNo, Integer pageSize) {
        search = "%" + search + "%";
        Pageable page = new PageRequest(pageNo, pageSize);
        Page<ScheduleJobLog> logPage = scheduleJobLogDAO.list(status, search, page);
        return convert2PageBean(logPage, pageNo, pageSize);
    }

    public PageBean<ScheduleJobLogVO> get(Long jobId, Integer pageNo, Integer pageSize) {
        Pageable page = new PageRequest(pageNo, pageSize);
        Page<ScheduleJobLog> logPage = scheduleJobLogDAO.get(jobId, page);
        return convert2PageBean(logPage, pageNo, pageSize);
    }

    public void finish(Long jobLogId) {
        ScheduleJobLog jobLog = scheduleJobLogDAO.findOne(jobLogId);
        jobLog.setJobLog(jobLog.getJobLog().concat("\n job finished!"));
        jobLog.setStatus(1);
        jobLog.setEndTime(System.currentTimeMillis());
        update(jobLog);
        LoggerHelper.info(getClass(), "job finished, jobId : {}", jobLog.getJobId());
    }

    public void errorEnd(Long jobLogId, String err) {
        ScheduleJobLog jobLog = scheduleJobLogDAO.findOne(jobLogId);
        jobLog.setJobLog(jobLog.getJobLog().concat("\n error: ") + err);
        jobLog.setStatus(2);
        jobLog.setEndTime(System.currentTimeMillis());
        update(jobLog);
    }

    private PageBean<ScheduleJobLogVO> convert2PageBean(Page<ScheduleJobLog> entityPage, int page, int pageSize) {
        PageBean<ScheduleJobLogVO> tagPageBean = new PageBean<>();
        tagPageBean.setData(convert2JobLogVO(entityPage.getContent()));
        tagPageBean.setPageNo(page);
        tagPageBean.setPageSize(pageSize);
        tagPageBean.setTotal(entityPage.getTotalElements());
        return tagPageBean;
    }

    private List<ScheduleJobLogVO> convert2JobLogVO(List<ScheduleJobLog> jobLoglist) {
        List<ScheduleJobLogVO> jobLogVOList = new ArrayList<>();
        for (ScheduleJobLog log : jobLoglist) {
            ScheduleJobLogVO jobLogVO = new ScheduleJobLogVO(log.getId(), log.getJobId(), log.getJobName(),
                    log.getJobType(), log.getParams(), log.getJobLog());
            jobLogVO.setStatus(convertStatus(log.getStatus()));
            jobLogVO.setStartTime(DateUtils.getDate2String(new Date(log.getStartTime())));
            if (null != log.getEndTime()) {
                jobLogVO.setEndTime(DateUtils.getDate2String(new Date(log.getEndTime())));
            }
            jobLogVOList.add(jobLogVO);
        }
        return jobLogVOList;
    }

    private String convertStatus(Integer status) {
        switch (status) {
            case 0:
                return "RUNNING";
            case 1:
                return "SUCCESS";
            case 2:
                return "FAIL";
            default:
                return "UNKNOW";
        }
    }
}
