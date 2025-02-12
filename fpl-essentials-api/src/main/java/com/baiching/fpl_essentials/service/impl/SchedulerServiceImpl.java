package com.baiching.fpl_essentials.service.impl;

import com.baiching.fpl_essentials.scheduledJobs.ScheduledJob;
import jakarta.annotation.PostConstruct;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class SchedulerServiceImpl {
    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @PostConstruct
    public void scheduleJob(String jobName, ZonedDateTime time) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();

        JobDetail job = JobBuilder.newJob(ScheduledJob.class)
                .withIdentity("simpleTrigger", "group1")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("simpleTrigger", "group1")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(10)
                        .repeatForever())
                .build();

        scheduler.scheduleJob(job, trigger);
    }
}
