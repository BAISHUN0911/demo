package org.example.infrastructure.thread;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/6/19 17:09
 */
public class WaitNotifyExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("当前线程名：" + Thread.currentThread().getName());
        SharedResource sharedResource = new SharedResource();
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+ "开始执行");
            sharedResource.doWait();
        }, "Thread-1");

        Thread notifyThread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+ "开始执行");
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+ "开始执行唤醒");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sharedResource.doNotify();
        }, "notifyThread");

        thread1.start();
        notifyThread.start();
        Thread.sleep(1000 * 15);

    }
}
