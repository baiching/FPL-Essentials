package com.baiching.fpl_essentials.scheduledJobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ScheduledJob implements Job {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String jobName = context.getJobDetail().getJobDataMap().getString("jobName");
        logger.info("Executing job: {}", jobName);

        performJobLogic(jobName);

        logger.info("Job '{}' completed successfully.", jobName);
    }

    private void performJobLogic(String jobName) {
        logger.info("Job '{}' is running at: {}", jobName, java.time.LocalDateTime.now());

    }
}
