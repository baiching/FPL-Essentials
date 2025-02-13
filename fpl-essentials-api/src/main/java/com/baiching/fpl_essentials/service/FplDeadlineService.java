package com.baiching.fpl_essentials.service;

import org.quartz.SchedulerException;

public interface FplDeadlineService {
    void deadlineReminder() throws SchedulerException;
}
