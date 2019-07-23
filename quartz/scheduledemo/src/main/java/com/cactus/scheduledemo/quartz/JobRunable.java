package com.cactus.scheduledemo.quartz;

/**
 * Created by liruigao on 2019-07-18.
 */
public abstract class JobRunable {

    public abstract void run (String params, Long jobLogId) throws Exception;

    public abstract void interrupt();
}
