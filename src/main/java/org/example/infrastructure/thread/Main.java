package org.example.infrastructure.thread;

/**
 * @description:
 * @Author BAISHUN
 * @Date 2024/8/19 17:04
 */
public class Main {
    public static void main(String[] args) {
        SynchronizedDemo singletonBusinessObj = new SynchronizedDemo();
        IncrementTask t1 = new IncrementTask(singletonBusinessObj);
        IncrementTask t2 = new IncrementTask(singletonBusinessObj);
        IncrementTask t3 = new IncrementTask(singletonBusinessObj);

        try {
            t1.start();
            t2.start();
            t3.start();
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(singletonBusinessObj.getCount());

    }
}
