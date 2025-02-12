package com.baiching.fpl_essentials.service;

import com.baiching.fpl_essentials.service.impl.SchedulerServiceImpl;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.time.ZonedDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SchedulerServiceImplTest {
    @Mock
    private SchedulerFactoryBean schedulerFactoryBean;

    @Mock
    private Scheduler scheduler;

    @InjectMocks
    private SchedulerServiceImpl schedulerService;

    @BeforeEach
    void setUp() throws SchedulerException {
        when(schedulerFactoryBean.getScheduler()).thenReturn(scheduler);
    }

    @Test
    void testScheduleJob() throws SchedulerException {
        String jobName = "testJob";
        ZonedDateTime time = ZonedDateTime.now();

        when(scheduler.scheduleJob(any(JobDetail.class), any(Trigger.class)))
                .thenReturn(Date.from(time.toInstant()));

        schedulerService.scheduleJob(jobName, time);

        verify(scheduler, times(1)).scheduleJob(any(JobDetail.class), any(Trigger.class));
    }

    @Test
    void testScheduleJob_ThrowsSchedulerException() throws SchedulerException {
        // Arrange
        String jobName = "testJob";
        ZonedDateTime time = ZonedDateTime.now();

        // Mock the scheduler to throw an exception
        when(scheduler.scheduleJob(any(JobDetail.class), any(Trigger.class)))
                .thenThrow(new SchedulerException("Failed to schedule job"));

        // Act & Assert
        assertThrows(SchedulerException.class, () -> {
            schedulerService.scheduleJob(jobName, time);
        });

        // Verify that the scheduler was called
        verify(scheduler, times(1)).scheduleJob(any(JobDetail.class), any(Trigger.class));
    }
}
