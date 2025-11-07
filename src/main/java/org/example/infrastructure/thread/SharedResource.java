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
                /*
                * 释放当前对象锁,进入等待队列（WAITING 状态）
                * 另一个线程调用了 this.notify() 或 this.notifyAll()，并且该线程释放了锁（退出 synchronized 块），当前等待线程才会被唤醒。
                * 唤醒后仍需要竞争锁，成功获取锁后，进入同步方法（RUNNABLE 状态）
                * */
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "begins to execute");
        // condition 为 true 时执行
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " is proceeding...");
        }
        condition = false;
    }
    public synchronized void doNotify() {
        // 修改执行标志
        condition = true;
        // 必须要唤醒正在等待的线程
        notify();
        System.out.println(Thread.currentThread().getName() + " has notified...");
    }
}
