package com.bingbingpa.job;

import com.bingbingpa.service.JobService;
import org.quartz.InterruptableJob;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class CronJob extends QuartzJobBean implements InterruptableJob {

    @Autowired
    private JobService jobService;
    private volatile boolean toStopFlag = true;


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        JobKey key = jobExecutionContext.getJobDetail().getKey();
        System.out.println("Cron Job started with key :" + key.getName() + ", Group :" + key.getGroup() + " , Thread Name :" + Thread.currentThread().getName() + " ,Time now :" + new Date());
        System.out.println("======================================");
        System.out.println("Accessing annotation example: " + jobService.getAllJobs());
        List<Map<String, Object>> list = jobService.getAllJobs();
        System.out.println("Job list :" + list);
        System.out.println("======================================");
        //*********** For retrieving stored key-value pairs ***********/
        JobDataMap dataMap = jobExecutionContext.getMergedJobDataMap();
        String myValue = dataMap.getString("myKey");
        System.out.println("Value:" + myValue);

        System.out.println("Thread: " + Thread.currentThread().getName() + " stopped.");
    }

    @Override
    public void interrupt() {
        System.out.println("Stopping thread... ");
        toStopFlag = false;
    }

}