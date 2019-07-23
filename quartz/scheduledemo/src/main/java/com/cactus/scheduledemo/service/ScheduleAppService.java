package com.cactus.scheduledemo.service;

import com.cactus.scheduledemo.core.bean.PageBean;
import com.cactus.scheduledemo.dao.IScheduleAppDAO;
import com.cactus.scheduledemo.domain.entity.ScheduleApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;

/**
 * Created by liruigao on 2019-07-10.
 */
@Service
public class ScheduleAppService {
    @Autowired
    private IScheduleAppDAO scheduleAppDAO;

    public PageBean<ScheduleApp> searchByPage(String search, Integer page, Integer pageSize) {
        search = "%" + search + "%";
        Pageable pageable = new PageRequest(page, pageSize);
        Page<ScheduleApp> appPage = scheduleAppDAO.searchByPage(search, pageable);
        return convert2PageBean(appPage, page, pageSize);
    }

    public void add(String name, String appDesc, String creator) {
        ScheduleApp app = new ScheduleApp();
        app.setName(name);
        app.setAppDesc(appDesc);
        app.setCreator(creator);
        app.setCreateTime(new Date(System.currentTimeMillis()));
        app.setUpdateTime(new Date(System.currentTimeMillis()));
        scheduleAppDAO.save(app);
    }

    public void update(Long id, String name, String appDesc, String updator) {
        scheduleAppDAO.update(name, appDesc, id, updator);
    }

    public void delete(Long id) {
        scheduleAppDAO.delete(id);
    }

    private PageBean<ScheduleApp> convert2PageBean(Page<ScheduleApp> entityPage, int page, int pageSize) {
        PageBean<ScheduleApp> tagPageBean = new PageBean<>();
        tagPageBean.setData(entityPage.getContent());
        tagPageBean.setPageNo(page);
        tagPageBean.setPageSize(pageSize);
        tagPageBean.setTotal(entityPage.getTotalElements());
        return tagPageBean;
    }
}
