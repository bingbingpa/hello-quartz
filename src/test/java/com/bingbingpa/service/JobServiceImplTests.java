package com.bingbingpa.service;

import com.bingbingpa.job.CronJob;
import com.bingbingpa.job.SimpleJob;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JobServiceImplTests {

    @Autowired
    private JobService jobService;

    @Test
    void JobServiceExecuteTest() {
//        jobService.scheduleOneTimeJob("testJob", CronJob.class, new Date());
        jobService.scheduleCronJob("testJob2", CronJob.class, new Date(), "1 * * * * ?");
//        jobService.deleteJob("testJob");
    }

}