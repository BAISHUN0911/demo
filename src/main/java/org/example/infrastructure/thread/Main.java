package org.example.infrastructure.thread;

/**
 * @description:
 * @Author BAISHUN
 * @Date 2024/8/19 17:04
 */
public class Main {
    public static void main(String[] args) {
//        Counter obj = new Counter();
        SynchronizedDemo obj = new SynchronizedDemo();
        IncrementTask2 t1 = new IncrementTask2(obj);
        IncrementTask2 t2 = new IncrementTask2(obj);
        IncrementTask2 t3 = new IncrementTask2(obj);

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

        System.out.println(obj.getCount());

    }
}

class IncrementTask extends Thread {
    private final Counter counter;

    public IncrementTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始执行run()");
        for (int i = 0; i < 1500; i++) {
            counter.increment();
        }
    }
}

class IncrementTask2 extends Thread {
    private final SynchronizedDemo counter;

    IncrementTask2(SynchronizedDemo counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始执行run()");
        for (int i = 0; i < 1500; i++) {
            counter.m1();
        }
    }
}
