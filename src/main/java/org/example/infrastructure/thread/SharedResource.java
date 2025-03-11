package org.example.infrastructure.thread;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/6/19 17:05
 */
public class SharedResource {
    private boolean condition = false;

    public synchronized void doWait() {
        while (!condition) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting...");
                this.wait(1000 * 2);
                wait();
                System.out.println(Thread.currentThread().getName() + " while end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " is proceeding...");
        }
    }
    public synchronized void doNotify() {
        condition = true;
        notify();
        System.out.println(Thread.currentThread().getName() + " has notified...");
    }
}
