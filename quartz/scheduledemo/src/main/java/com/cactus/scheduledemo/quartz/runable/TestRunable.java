package com.cactus.scheduledemo.quartz.runable;


import com.cactus.scheduledemo.core.helper.LoggerHelper;
import com.cactus.scheduledemo.quartz.JobRunable;
import org.springframework.stereotype.Service;

/**
 * Created by liruigao on 2019-07-18.
 */
@Service("test")
public class TestRunable extends JobRunable {

    @Override
    public void run(String params, Long logId) throws Exception {
        LoggerHelper.info(getClass(), "params: " + params);
    }

    @Override
    public void interrupt() {
        LoggerHelper.info(getClass(), "this job could not be interrupt!");
    }
}
