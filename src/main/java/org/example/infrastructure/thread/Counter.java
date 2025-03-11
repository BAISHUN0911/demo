package org.example.infrastructure.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @Author BAISHUN
 * @Date 2024/8/19 17:08
 */
public class Counter {
    private int count = 0;

    private final Lock lock = new ReentrantLock();

    // 线程不安全，多线程环境下，最后的count值不符合预期
    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
