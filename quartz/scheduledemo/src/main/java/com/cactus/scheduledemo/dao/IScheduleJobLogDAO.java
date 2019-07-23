package com.cactus.scheduledemo.dao;

import com.cactus.scheduledemo.domain.entity.ScheduleJobLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by liruigao on 2019-07-16.
 */
public interface IScheduleJobLogDAO extends JpaRepository<ScheduleJobLog, Long> {

    @Query(value = "from ScheduleJobLog t where t.status = :status "
                + "and t.jobName like :search  order by t.createTime desc")
    Page<ScheduleJobLog> list(@Param("status") Integer status,
                              @Param("search") String search, Pageable page);

    @Query(value = "from ScheduleJobLog t where t.jobId = :jobId order by t.createTime desc")
    Page<ScheduleJobLog> get(@Param("jobId") Long jobId, Pageable page);
}
