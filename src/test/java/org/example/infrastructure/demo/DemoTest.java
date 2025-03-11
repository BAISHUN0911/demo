package org.example.infrastructure.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DemoTest {
    @Test
    void test1() {
        Demo demo1 = new Demo(10);
        Demo demo2 = new Demo(10);
        System.out.println(demo1 == demo2);
        System.out.println(demo1.equals(demo2));
    }
}