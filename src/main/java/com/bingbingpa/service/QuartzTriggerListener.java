package com.bingbingpa.service;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.Trigger.CompletedExecutionInstruction;
import org.quartz.TriggerListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QuartzTriggerListener implements TriggerListener {
    @Override
    public String getName() {
        return "globalTrigger";
    }

    /**
     * trigger 가 실행될 때 호출되는 메서드
     * @param trigger
     * @param context
     */
    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        log.info("===============QuartzTriggerListener.triggerFired()===============");
    }

    /**
     * triggerFired 메서드가 호출 된 후에 실행되는 메서드
     * @param trigger
     * @param context
     * @return
     */
    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        log.info("===============QuartzTriggerListener.vetoJobExecution()===============");
        return false;
    }

    /**
     * trigger 가 misfired 될 때 실행되는 메서드
     * @param trigger
     */
    @Override
    public void triggerMisfired(Trigger trigger) {
        log.info("===============QuartzTriggerListener.triggerMisfired()===============");
        log.info("===============Job name: {} is misfired===============", trigger.getKey().getName());
    }

    /**
     * trigger 실행이 완료되고 호출되는 메서드
     * @param trigger
     * @param context
     * @param triggerInstructionCode
     */
    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context, CompletedExecutionInstruction triggerInstructionCode) {
        log.info("===============QuartzTriggerListener.triggerComplete()===============");
    }
}
