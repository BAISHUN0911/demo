package org.example.infrastructure.thread;

import lombok.Getter;

/**
 * @description: Synchronized使用示例
 * @Author BAISHUN
 * @Date 2024/8/19 16:44
 */
@Getter
public class SynchronizedDemo {
    private int count = 0;

    /**
     * 非同步方法，并发修改最终结果可能不是预期
     */
    public void m() {
        System.out.println("进入方法,当前线程：" + Thread.currentThread().getName());
        count++;
        System.out.println("当前线程：" + Thread.currentThread().getName() + "执行完m，count值为：" + count);
    }

    // 保证了线程安全，同一时刻只能有一个线程调用该方法，最终count值符合预期
    public synchronized void m1() {
        System.out.println("进入同步方法，当前线程：" + Thread.currentThread().getName());
        count++;
        System.out.println("当前线程：" + Thread.currentThread().getName() + "执行完m1，count值为：" + count);
    }

    public synchronized static void m2() {
        System.out.println("进入同步方法[静态方法]");

    }

    public void m3() {
        synchronized (this) {
            System.out.println("进入同步代码块");
        }
    }

}
