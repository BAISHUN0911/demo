package org.example.infrastructure.algorithm.stack;

import java.util.ArrayDeque;

/**
 * 给一个入栈序列[1, 2, 3, 4, 5],判断出栈序列[4, 5, 3, 2, 1]是否是可能的？
 *
 * @Author BAISHUN
 * @Date: 2024/7/1 12:30
 */
public class ValidateStackSequences {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        int[] popped2 = {4, 5, 3, 1, 2};
        System.out.println(validateStackSequences(pushed, popped));
        System.out.println(validateStackSequences(pushed, popped2));
    }

    /**
     * for循环根据入栈序列去压栈，每次压栈后判断栈顶与当前popped[index]是否相等，相等则弹栈，最后看栈是否为空
     *
     * @param pushed 入栈序列
     * @param popped 出栈序列
     * @return 布尔值
     */
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        for (int i : pushed) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
