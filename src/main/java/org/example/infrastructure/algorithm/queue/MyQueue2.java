package org.example.infrastructure.algorithm.queue;

/**
 * 通过 数组 实现队列
 *
 * @Author BAISHUN
 * @Date: 2024/7/1 13:00
 */
public class MyQueue2 {
    int[] data; //用数组来模拟队列中存放的数据

    int size = 0; //队列中元素的个数

    int maxSize;    //队列中最多存放数据的个数

    MyQueue2() {
    }

    MyQueue2(int maxSize) {
        this.maxSize = maxSize;
        data = new int[maxSize];    //一定记得初始化数组，不然后续操作空指针
    }

    // 入队
    void offer(int val) {
        if (this.size == this.maxSize) {
            System.out.println("error, the queue is full");
        } else {
            data[this.maxSize - size - 1] = val;
            this.size++;
        }
    }

    // 出队
    void poll() {
        if (this.size == 0) {
            System.out.println("error, the queue is empty");
        } else {
            System.out.println(data[this.maxSize - 1]);
            if (size >= 2) {
                this.size--;
                for (int i = 0; i < size; i++) {
                    data[this.maxSize - i - 1] = data[this.maxSize - i - 2];
                }
            } else {
                this.size--;
            }
        }
    }
}
