package org.example.framework.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/6/4 23:18
 */
@Component
@Slf4j
public class AopDemoService {
    @DemoLog(operator = "admin1")
    public void method() {
        log.info("current method is running...");
    }

}
