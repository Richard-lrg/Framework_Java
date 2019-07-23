package com.cactus.scheduledemo.dao;

import com.cactus.scheduledemo.domain.entity.ScheduleJob;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by liruigao on 2019-06-09.
 */
public interface IScheduleJobDAO extends JpaRepository<ScheduleJob, Long> {
    @Transactional
    @Modifying
    @Query("update ScheduleJob set status = :status where jobId = :jobId")
    void updateStatus(@Param("jobId") Long jobId, @Param("status") Integer status);

    @Query("from ScheduleJob where jobId = :jobId")
    ScheduleJob get(@Param("jobId") Long jobId);

    @Query(value = "from ScheduleJob t where t.appId = :appId and t.jobName like :jobName")
    Page<ScheduleJob> searchByPage(@Param("appId") Long appId, @Param("jobName") String jobName, Pageable page);

    @Transactional
    @Modifying
    @Query(value = "update schedule_job set job_name = ?2, status = ?3, job_desc = ?4, "
                    + "cron_expression = ?5, job_type = ?6, job_priority = ?7, params = ?8, update_time = ?9, "
                    + "start_time = ?10, end_time = ?11 where job_id = ?1", nativeQuery = true)
    void update(Long jobId, String jobName, Integer status, String jobDesc, String jobCron,
                String jobType, Integer jobPriority, String params, Long updateTime,
                Long startTime, Long endTime);
}
