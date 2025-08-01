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
    // 创建一个可重入锁
    private final ReentrantLock lock = new ReentrantLock();

    /**
     * 创建一个线程池，用来执行多线程
     */
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
//            executor.submit(this::m1);
            executor.submit(this::m2);
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

    /** 可重入锁示例 已获取锁的线程可再次获取锁 */
    public void outerMethod() {
        // 线程第一次获取锁
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 在 outerMethod 中获取了锁");
            innerMethod(); // 调用内部方法，再次尝试获取锁
        } finally {
            // 线程第一次释放锁
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " 在 outerMethod 中释放了锁");
        }
    }

    public void innerMethod() {
        // 线程第二次获取锁（因为是同一个线程，所以不会被阻塞）
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 在 innerMethod 中成功获取了锁");
        } finally {
            // 线程第二次释放锁
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " 在 innerMethod 中释放了锁");
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo demo = new ReentrantLockDemo();
//        System.out.println(demo.doM1());
        demo.outerMethod();
    }

}