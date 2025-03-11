package org.example.infrastructure.algorithm.stack;

/**
 * @description:
 * @Author BAISHUN
 * @Date 2024/8/31 10:41
 */
public class Main {
    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        myStack.push("1");
        myStack.push("2");
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
    }
}
