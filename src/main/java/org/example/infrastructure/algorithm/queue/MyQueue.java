package org.example.infrastructure.algorithm.queue;

import lombok.Data;

/**
 * 自定义队列实现
 *
 * @Author BAISHUN
 * @Date: 2024/6/26 17:26
 */
@Data
public class MyQueue {
    // 存放队列中的元素
    private Object[] elements;
    // 指向当前队头
    private Integer head = 0;

    private Integer cur = 0;

    public MyQueue() {
        elements = new Object[16];
    }

    public void offer(Object obj) {
        elements[cur] = obj;
        cur++;
    }

    public Object poll() {
        Object obj = elements[head];
        head++;
        return obj;
    }
}
