package com.baiching.fpl_essentials.service.impl;

import jakarta.annotation.PostConstruct;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuartzSchedulerServiceImpl {
    @Autowired
    private Scheduler scheduler;

    @PostConstruct
    public void scheduleJob() throws SchedulerException {
        JobDetail job = JobBuilder.newJob(HelloWorldJob.class)
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
