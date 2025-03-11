package org.example.framework.quartz;

import org.junit.jupiter.api.Test;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScheduledTaskDemoTest {
    @Autowired
    private ScheduledTaskDemo scheduledTaskDemo;

    @Test
    void testScheduleTask() {
        try {
            scheduledTaskDemo.scheduleAward("123", "1");
            Thread.sleep(1000 * 70);
        } catch (SchedulerException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}