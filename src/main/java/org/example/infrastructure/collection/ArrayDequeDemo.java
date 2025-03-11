package org.example.infrastructure.collection;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * ArrayDeque 既可以做栈也可以做队列
 *
 * @Author BAISHUN
 * @Date: 2024/7/1 12:14
 */
public class ArrayDequeDemo {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(12);
        stack.push(21);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
//        System.out.println(stack.pop());        // 如果栈空，抛异常NoSuchElementException

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list.get(1));
        System.out.println(list.get(0));

        System.out.println("ArrayDeque做队列");
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(1);
        queue.offerLast(2);
        System.out.println("ArrayDeque默认peek相当于peekFirst()");
        System.out.println(queue.peek());
        System.out.println("队列为空时,getFirst()抛异常");
        System.out.println(queue.getFirst());
        System.out.println("队列为空时，pollFirst()返回null，removeFirst()抛异常");
        System.out.println(queue.pollFirst());
        System.out.println(queue.removeFirst());
        System.out.println("队列为空时");
        System.out.println(queue.pollFirst());
        System.out.println(queue.removeFirst());
    }
}
