package org.example.framework.quartz;

import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/6/6 23:24
 */
@Configuration
public class ScheduledTaskDemo {
//    @Autowired
//    private SchedulerFactory stdSchedulerFactory;

    @Bean
    public Scheduler scheduler() throws SchedulerException {
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        scheduler.start();
        return scheduler;
    }

    public void scheduleAward(String packetId, String time) throws SchedulerException {
        Scheduler scheduler = scheduler();
        JobDetail jobDetail = JobBuilder.newJob(RedPacketJob.class).withIdentity(packetId).build();

        Trigger trigger = TriggerBuilder.newTrigger().
                withIdentity(packetId).startAt(DateBuilder.futureDate(1, DateBuilder.IntervalUnit.MINUTE))
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
    }


}
