package org.example.infrastructure.collection;

import java.util.Stack;

/**
 * @description: Stack实现栈
 * @Author BAISHUN
 * @Date 2024/9/9 16:51
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(null);       // Stack可以存储null元素，并且可以存储多个
        stack.push(null);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());    // EmptyStackException异常
        System.out.println();
    }
}
