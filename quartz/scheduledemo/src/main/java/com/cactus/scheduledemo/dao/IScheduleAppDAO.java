package com.cactus.scheduledemo.dao;

import com.cactus.scheduledemo.domain.entity.ScheduleApp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by liruigao on 2019-07-10.
 */
public interface IScheduleAppDAO extends JpaRepository<ScheduleApp, Long> {
    @Transactional
    @Modifying
    @Query(value = "update ScheduleApp set name = :name, appDesc = :appDesc, updator = :updator where id = :id")
    void update(@Param("name") String name, @Param("appDesc") String appDesc,
                @Param("id") Long id, @Param("updator") String updator);

    @Query(value = "from ScheduleApp t where t.name like :search")
    Page<ScheduleApp> searchByPage(@Param("search") String search, Pageable page);

}
