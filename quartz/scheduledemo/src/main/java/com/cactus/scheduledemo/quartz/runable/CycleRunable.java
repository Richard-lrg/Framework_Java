package com.cactus.scheduledemo.quartz.runable;

import com.cactus.scheduledemo.quartz.JobRunable;
import org.springframework.stereotype.Service;

/**
 * Created by liruigao on 2019-07-19.
 */
@Service("cycle")
public class CycleRunable extends JobRunable {
    private Boolean interrupted;

    private void init() {
        this.interrupted = false;
    }

    @Override
    public void run(String params, Long jobLogId) throws Exception {
        init();
        Integer i = 0;
        for (int j = 0; j < 50; j++) {
            if (!interrupted) {
                Thread.sleep(1000L);
                System.out.println("this is cycleRunable job -- " + (i++));
            } else {
                System.out.println("cycleRunable job is interupt");
                interrupted = false;
                return;
            }
        }
    }

    @Override
    public void interrupt() {
        this.interrupted = true;
    }
}
