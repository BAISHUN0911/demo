package org.example.infrastructure.thread;

/**
 * @description: Synchronized使用示例
 * @Author BAISHUN
 * @Date 2024/8/19 16:44
 */
public class SynchronizedDemo {
    private int count = 0;

    public int getCount() {
        return count;
    }

    // 保证了线程安全，同一时刻只能有一个线程调用该方法，最终count值符合预期
    public synchronized void m1 () {
        count++;
    }

    public synchronized static void m2 () {
        System.out.println("进入同步方法[静态方法]");

    }

    public void m3() {
        synchronized (this) {
            System.out.println("进入同步代码块");
        }
    }

}
