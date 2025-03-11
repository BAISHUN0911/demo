package org.example.infrastructure.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/6/6 22:22
 */
public class CompletableFutureDemo {
    public static void main(String[] args) {
        /**
         * runAsync方法接受一个Runnable作为参数，该Runnable没有返回值，因此runAsync方法返回的是一个CompletableFuture<Void>对象，该对象最终不会包含任何结果
         * runAsync方法中的异步任务不能抛出受检异常，只能在异步任务内部使用try-catch块来处理异常
         */
        CompletableFuture<Void> future0 = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        });
        /**
         * supplyAsync方法接受一个Supplier作为参数，该Supplier返回一个结果，因此supplyAsync方法返回的是一个CompletableFuture对象，该对象最终会包含异步任务的结果
         * supplyAsync方法中的异步任务可以抛出受检异常，可以使用exceptionally方法来处理异常
         */
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "future success, end.";
        });
        // 当异步任务完成时，执行相应的操作
        // 使用thenAccept()方法注册了一个回调函数，当异步任务完成时会执行这个回调函数，打印出异步任务的结果
        future.thenAccept(result -> {
            System.out.println("异步任务调用结束, 结果为：" + result);
        });
        // 阻塞等待异步任务的完成，并获取结果
        try {
            String result = future.get();
            System.out.println("异步任务执行结果为: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
