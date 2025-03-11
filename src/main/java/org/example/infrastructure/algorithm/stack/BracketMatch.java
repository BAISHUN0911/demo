package org.example.infrastructure.algorithm.stack;

import java.util.ArrayDeque;

/**
 * @description: 括号匹配
 * @Author BAISHUN
 * @Date 2024/9/1 15:58
 */
public class BracketMatch {
    public static void main(String[] args) {
        String s = "{[](){()}}";
        String s2 = "[{]}";
        System.out.println(match(s));
        System.out.println(match(s2));
    }

    public static boolean match(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!isMatching(top, c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatching(char top, char c) {
        return (c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{');
    }

    private boolean haveBracket(String s, ArrayDeque<String> stack) {
        ArrayDeque<String> temp = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            if (stack.peek().equals(s)) {
                stack.pop();
                while (!temp.isEmpty()) {
                    stack.push(temp.pop());
                }
                return true;
            }
            temp.push(stack.pop());
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        return false;
    }

}
