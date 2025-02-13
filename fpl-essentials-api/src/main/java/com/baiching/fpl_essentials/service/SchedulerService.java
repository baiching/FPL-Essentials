package com.baiching.fpl_essentials.service;

import org.quartz.SchedulerException;

import java.time.ZonedDateTime;

public interface SchedulerService {
    void scheduleJob(String taskName, String email, ZonedDateTime emailTime) throws SchedulerException;
}
