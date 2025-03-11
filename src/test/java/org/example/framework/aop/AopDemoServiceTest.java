package org.example.framework.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AopDemoServiceTest {
    @Autowired
    private AopDemoService service;

    @Test
    void test1() {
        service.method();
    }
}