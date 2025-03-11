package org.example.infrastructure.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: 自定义栈
 * @Author BAISHUN
 * @Date 2024/8/31 10:19
 */
public class MyStack<T> {

    private Deque<T> stack = new ArrayDeque<>();

    public void push(T value) {
        stack.push(value);
        System.out.println("向栈中压入元素：" + value);
    }

    public T pop() {
        return stack.isEmpty() ? null : stack.pop();
    }

    public T peek() {
        return stack.isEmpty() ? null : stack.peek();
    }

}
