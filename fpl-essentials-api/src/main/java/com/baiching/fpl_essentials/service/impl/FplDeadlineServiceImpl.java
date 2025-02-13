package com.baiching.fpl_essentials.service.impl;

import com.baiching.fpl_essentials.model.Gameweek;
import com.baiching.fpl_essentials.repository.GameWeekDeadlineRepository;
import com.baiching.fpl_essentials.service.SchedulerService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class FplDeadlineServiceImpl implements com.baiching.fpl_essentials.service.FplDeadlineService {
    @Autowired
    GameWeekDeadlineRepository repository;

    @Autowired
    SchedulerService schedulerService;

    @Override
    public void deadlineReminder() throws SchedulerException {
        List<Gameweek> overallData = repository.findAll();

        ZonedDateTime currentTime = ZonedDateTime.now();

        for (Gameweek gameweek : overallData) {
            ZonedDateTime deadlineDate = ZonedDateTime.parse(gameweek.getDeadline_time());

            if (deadlineDate.isAfter(currentTime)) {
                ZonedDateTime emailTime = deadlineDate.minusMinutes(30);

                scheduleEmail(gameweek.getName(), "user@example.com", emailTime);
            } else {
                System.out.println("Task '" + gameweek.getName() + "' has already passed its deadline.");
            }

        }
    }

    private void scheduleEmail(String name, String mail, ZonedDateTime emailTime) throws SchedulerException {
        schedulerService.scheduleJob(name, mail, emailTime);
    }
}
