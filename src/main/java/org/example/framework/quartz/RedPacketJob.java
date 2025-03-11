package org.example.framework.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/6/6 23:36
 */
@Component
public class RedPacketJob implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        // 在这里编写红包发放的逻辑，可以根据传入的参数执行不同的操作
        System.out.println("执行红包发放任务...");
    }
}
