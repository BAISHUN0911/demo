package org.example.infrastructure.thread;

public class IncrementTask extends Thread {
    private final SynchronizedDemo counter;

    IncrementTask(SynchronizedDemo counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始执行run()");
        for (int i = 0; i < 200000; i++) {
            counter.m();
        }
    }
}
