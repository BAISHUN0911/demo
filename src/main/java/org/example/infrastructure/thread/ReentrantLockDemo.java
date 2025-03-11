package org.example.infrastructure.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @Author BAISHUN
 * @Date 2024/8/24 10:01
 */
public class ReentrantLockDemo {
    private final ReentrantLock lock = new ReentrantLock();

    private final ExecutorService executor = Executors.newFixedThreadPool(8);

    /**
     * 加锁可以保证同一时间只能有一个线程执行该代码块
     */
    public void m1() {
        lock.lock();
        try {
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName() + " working...");
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * 多线程下会有多个线程同时执行该代码块，出现交替打印的情景
     */
    public void m2() {
        for (int i = 0; i < 2; i++) {
            System.out.println(Thread.currentThread().getName() + " working...");
        }
    }

    public String doM1() {
        for (int i = 0; i < 8; i++) {
            executor.submit(this::m1);
//            executor.submit(this::m2);
        }
        try {
            Thread.sleep(1000 * 1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }
        return "ok";
    }

    public static void main(String[] args) {
        ReentrantLockDemo demo = new ReentrantLockDemo();
        System.out.println(demo.doM1());
    }

}