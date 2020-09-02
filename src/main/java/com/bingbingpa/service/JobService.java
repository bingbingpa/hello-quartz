package com.bingbingpa.service;

import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface JobService {
    boolean scheduleOneTimeJob(String jobName, Class<? extends QuartzJobBean> jobClass, LocalDate date);

    boolean scheduleCronJob(String jobName, Class<? extends QuartzJobBean> jobClass, LocalDate date, String cronExpression);

    boolean updateOneTimeJob(String jobName, LocalDate date);

    boolean updateCronJob(String jobName, LocalDate date, String cronExpression);

    boolean unScheduleJob(String jobName);

    boolean deleteJob(String jobName);

    boolean pauseJob(String jobName);

    boolean resumeJob(String jobName);

    boolean startJobNow(String jobName);

    boolean isJobRunning(String jobName);

    List<Map<String, Object>> getAllJobs();

    boolean isJobWithNamePresent(String jobName);

    String getJobState(String jobName);

    boolean stopJob(String jobName);
}
