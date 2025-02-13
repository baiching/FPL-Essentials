package com.baiching.fpl_essentials.service.impl;

import com.baiching.fpl_essentials.scheduledJobs.EmailJob;
import com.baiching.fpl_essentials.service.SchedulerService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Date;

@Service
public class SchedulerServiceImpl implements SchedulerService {
    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @Override
    public void scheduleJob(String taskName, String email, ZonedDateTime emailTime) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();

        JobDetail job = JobBuilder.newJob(EmailJob.class)
                .withIdentity(taskName + "EmailJob", "emailGroup")
                .usingJobData("taskName", taskName)
                .usingJobData("email", email)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(taskName + "EmailTrigger", "emailGroup")
                .startAt(Date.from(emailTime.toInstant()))
                .build();

        scheduler.scheduleJob(job, trigger);
    }
}
