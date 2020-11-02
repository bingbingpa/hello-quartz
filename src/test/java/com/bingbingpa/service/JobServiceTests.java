package com.bingbingpa.service;

import com.bingbingpa.job.CronJob;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;


@Slf4j
@SpringBootTest
class JobServiceTests {

    private final String JOB_NAME = "testJob3dhsmf";

    @Autowired
    private JobService jobService;

    @Test
    void scheduleOneTimeJob() {
    }

    @Test
    void scheduleCronJob() {
        jobService.scheduleCronJob(JOB_NAME, CronJob.class, new Date(), "1 * * * * ?");
    }

    @Test
    void updateOneTimeJob() {
    }

    @Test
    void updateCronJob() {
    }

    @Test
    void unScheduleJob() {
    }

    @Test
    void deleteJob() {
    }

    @Test
    void pauseJob() {
        jobService.pauseJob(JOB_NAME);
    }

    @Test
    void resumeJob() {
        jobService.resumeJob(JOB_NAME);
    }

    @Test
    void startJobNow() {
        jobService.startJobNow(JOB_NAME);
    }

    @Test
    void isJobRunning() {
        jobService.isJobRunning(JOB_NAME);
    }

    @Test
    void getAllJobs() {
    }

    @Test
    void isJobWithNamePresent() {
    }

    @Test
    void getJobState() {
    }

    @Test
    void stopJob() {
    }
}