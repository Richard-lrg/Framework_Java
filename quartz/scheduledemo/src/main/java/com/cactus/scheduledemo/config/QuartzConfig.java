package com.cactus.scheduledemo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by liruigao on 2019-06-09.
 * 定时任务配置
 */
@Configuration
public class QuartzConfig {

    @Bean
    public SchedulerFactoryBean scheduler(@Qualifier("dataSource") DataSource dataSource) {
        // quartz参数
        Properties prop = new Properties();
        // 使用配置文件
        prop.put("org.quartz.jobStore.useProperties", "true");
        // 配置实例
        prop.put("org.quartz.scheduler.instanceId", "AUTO");
        // 线程池配置
        prop.put("org.quartz.threadPool.threadCount", "5");
        // JobStore配置
        prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
        prop.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
        // 信息保存时间 默认值60秒(实际执行时间与下一次应该执行时间之间的差值，超过这个差值就不会执行，低于这个差值就会执行)
        prop.put("org.quartz.jobStore.misfireThreshold", "5000");
        // 跳过更新检查
        prop.put("org.quartz.scheduler.skipUpdateCheck", "true");
        // 启用集群
        prop.put("org.quartz.jobStore.isClustered", "true");
        prop.put("org.quartz.jobStore.clusterCheckinInterval", "10000");

        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setApplicationContextSchedulerContextKey("applicationContextKey");
        factory.setDataSource(dataSource);
        factory.setQuartzProperties(prop);
        // 数据库中存储的名字
        factory.setSchedulerName("cactus-scheduler");
        // 延时启动，应用启动5秒后 QuartzScheduler 再启动
        factory.setStartupDelay(5);
        // 可选，QuartzScheduler 启动时更新己存在的Job，这样就不用每次修改targetObject后删除qrtz_job_details表对应记录了
        factory.setOverwriteExistingJobs(true);
        // 设置自动启动，默认为true
        factory.setAutoStartup(true);
        return factory;
    }
}
