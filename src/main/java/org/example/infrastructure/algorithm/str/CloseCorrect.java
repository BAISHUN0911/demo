package org.example.infrastructure.algorithm.str;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * 判断给定的字符串是否正确关闭
 * {}{}、{()}是正确关闭的，((、{)(不是关闭的 {(})不算正确关闭
 * 注意：括号字符只有{}、()、[]三种
 * 使用栈
 *
 * @Author BAISHUN
 * @Date: 2024/6/24 15:51
 */
public class CloseCorrect {
    public static void main(String[] args) {
        String str = "{(})";
        System.out.println(isClosed(str));
    }

    /**
     * map集合记录左右括号，使用栈压入每一个左括号，当出现右括号时弹栈进行判断
     *
     * @param s 待判断字符串
     * @return 布尔值
     */
    public static boolean isClosed(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                Character top = stack.isEmpty() ? '#' : stack.pop();
                if (!top.equals(map.get(c))) {
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return true;
    }
}
