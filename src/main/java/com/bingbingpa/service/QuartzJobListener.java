package com.bingbingpa.service;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QuartzJobListener implements JobListener {

    @Override
    public String getName() {
        return "globalJob";
    }

    /**
     * JobDetail 이 실행될 떄 스케줄러에의해서 호출되는 메서드
     * @param context JobExecutionContext
     */
    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        log.info("===============QuartzJobListener.jobToBeExecuted()===============");
    }

    /**
     * JobDetail 이 실행될 때 TriggerListener 가 실행
     * @param context JobExecutionContext
     */
    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        log.info("===============QuartzJobListener.jobExecutionVetoed()===============");
    }

    /**
     * Job 실행이 완료된 후 호출되는 메서드, JOB 실행후 처리할 로직을 여기에 구현
     * @param context JobExecutionContext
     * @param jobException JobExecutionException
     */
    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        log.info("===============QuartzJobListener.jobWasExecuted()===============");
    }
}

