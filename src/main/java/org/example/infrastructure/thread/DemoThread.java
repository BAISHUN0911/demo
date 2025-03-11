package org.example.infrastructure.thread;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/6/19 16:41
 */
public class DemoThread implements Runnable{
    @Override
    public void run() {
        System.out.println("当前线程：" + Thread.currentThread().getName() + " running...");
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("当前线程：" + Thread.currentThread().getName() + " over");
    }
}
