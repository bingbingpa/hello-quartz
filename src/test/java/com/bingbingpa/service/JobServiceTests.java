package com.bingbingpa.service;

import com.bingbingpa.job.CronJob;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class JobServiceTests {

    @Autowired
    private JobService jobService;

    @Test
    void scheduleOneTimeJob() {
    }

    @Test
    void scheduleCronJob() {
        jobService.scheduleCronJob("testJob2", CronJob.class, new Date(), "1 * * * * ?");
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
    }

    @Test
    void resumeJob() {
    }

    @Test
    void startJobNow() {
    }

    @Test
    void isJobRunning() {
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