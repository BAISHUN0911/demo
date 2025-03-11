package org.example.infrastructure.algorithm.queue;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/6/26 17:33
 */
public class QueueTest {
    public static void main(String[] args) {
//        MyQueue queue = new MyQueue();
//        queue.offer(1);
//        queue.offer(2);
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());

        MyQueue2 myQueue2 = new MyQueue2(3);
        myQueue2.offer(1);
        myQueue2.offer(2);
        myQueue2.offer(3);
        myQueue2.poll();
        myQueue2.poll();
        myQueue2.poll();
        myQueue2.poll();
    }
}
