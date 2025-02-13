package com.baiching.fpl_essentials.scheduledJobs;

import com.baiching.fpl_essentials.model.EmailDetails;
import com.baiching.fpl_essentials.service.EmailService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailJob implements Job {

    @Autowired
    EmailDetails details;

    @Autowired
    EmailService emailService;

    private static final Logger logger = LoggerFactory.getLogger(EmailJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String taskName = context.getJobDetail().getJobDataMap().getString("taskName");
        String email = context.getJobDetail().getJobDataMap().getString("email");

        performJobLogic(taskName, email);

//        logger.info("Job '{}' completed successfully.", jobName);
    }

    private void performJobLogic(String taskName, String email) {
        details.setRecipient(email);
        details.setMsgBody("Update your team!!! only 30 minutes remain");
        details.setSubject("Deadline Reminder");

        emailService.sendSimpleEmail(details);
    }
}
