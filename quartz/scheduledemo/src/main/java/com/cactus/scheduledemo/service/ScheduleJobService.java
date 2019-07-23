package com.cactus.scheduledemo.service;

import com.cactus.scheduledemo.core.bean.PageBean;
import com.cactus.scheduledemo.core.utils.DateUtils;
import com.cactus.scheduledemo.dao.IScheduleJobDAO;
import com.cactus.scheduledemo.domain.entity.ScheduleJob;
import com.cactus.scheduledemo.domain.vo.ScheduleJobVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liruigao on 2019-06-11.
 */
@Service
public class ScheduleJobService {
    @Autowired
    private IScheduleJobDAO scheduleJobDAO;

    public PageBean<ScheduleJobVO> searchByPage(Long appId, String search, Integer page, Integer pageSize) {
        search = "%" + search + "%";
        Pageable pageable = new PageRequest(page, pageSize);
        Page<ScheduleJob> jobPage = scheduleJobDAO.searchByPage(appId, search, pageable);
        return convert2PageBean(jobPage, page, pageSize);
    }

    public ScheduleJob get(Long jobId) {
        ScheduleJob job = scheduleJobDAO.get(jobId);
        return job;
    }

    public ScheduleJob save(ScheduleJob scheduleJob) {
        final ScheduleJob job = scheduleJobDAO.save(scheduleJob);
        return job;
    }

    public void update(ScheduleJob job) {
        scheduleJobDAO.update(job.getJobId(), job.getJobName(), job.getStatus(), job.getJobDesc(),
                job.getCronExpression(), job.getJobType(), job.getJobPriority(), job.getParams(),
                job.getUpdateTime(), job.getStartTime(), job.getEndTime());
    }

    public void updateStatus(Long jobId, Integer status) {
        scheduleJobDAO.updateStatus(jobId, status);
    }

    public void delete(Long jobId) {
        scheduleJobDAO.delete(jobId);
    }

    private PageBean<ScheduleJobVO> convert2PageBean(Page<ScheduleJob> entityPage, int page, int pageSize) {
        PageBean<ScheduleJobVO> tagPageBean = new PageBean<>();
        tagPageBean.setData(convert2VO(entityPage.getContent()));
        tagPageBean.setPageNo(page);
        tagPageBean.setPageSize(pageSize);
        tagPageBean.setTotal(entityPage.getTotalElements());
        return tagPageBean;
    }

    private List<ScheduleJobVO> convert2VO(List<ScheduleJob> jobList) {
        List<ScheduleJobVO> jobVOList = new ArrayList<>();
        for (ScheduleJob job : jobList) {
            String status = job.getStatus() == 0 ? "RUN" : "STOP";
            ScheduleJobVO jobVO = new ScheduleJobVO(job.getJobId(), job.getJobName(),
                    status, job.getJobDesc(), job.getCronExpression(), job.getJobType(),
                    job.getJobPriority(), job.getParams(), DateUtils.getDate2String(new Date(job.getCreateTime())));
            jobVOList.add(jobVO);
        }
        return jobVOList;
    }
}
