package org.example.infrastructure.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 查看一个main方法都包含了哪些线程
 *
 * @Author BAISHUN
 * @Date: 2024/6/19 16:27
 */
public class MultiThread {
    public static void main(String[] args) throws InterruptedException {
        getAllThread();
        DemoThread demoThread = new DemoThread();
        Thread thread1 = new Thread(demoThread, "thread-1");
        thread1.start();
        thread1.wait(1000 * 3);
    }

    private static void getAllThread() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        }
    }
}
