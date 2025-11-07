package org.example.infrastructure.thread;

import java.util.concurrent.Semaphore;

public class AlternatePrintSemaphore {
    private static Semaphore semA = new Semaphore(1); // 允许A先执行
    private static Semaphore semB = new Semaphore(0);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    semA.acquire();
                    System.out.println("A");
                    semB.release();
                    // 这里不能再释放semA，释放会立即获取到然后连续打印A
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    semB.acquire();
                    System.out.println("B");
                    semA.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
