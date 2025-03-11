package org.example.infrastructure.algorithm.str;

import java.util.HashMap;

/**
 * @description: 根据说明判断字符串是否匹配
 * 要求输入一个匹配模式（简单的以字符来写）， 比如 aabb, 来判断该字符串是否符合该模式
 * 例如模式：aabb 字符串：你好 你好 中国 中国 符合匹配
 * 特殊情况：abc 字符串：菜鸟 菜鸟 菜鸟 也符合
 * @Author BAISHUN
 * @Date 2024/8/11 21:52
 */
public class PatternMatch {
    public static void main(String[] args) {
        System.out.println(patternMatch("菜鸟1 菜鸟2 菜鸟3 菜鸟3", "abbc"));
    }

    public static boolean patternMatch(String str, String pattern) {
        if (str == null || pattern == null || str.isEmpty() || pattern.isEmpty()) {
            return false;
        }
        String[] arr = str.split(" ");
        if (arr.length != pattern.length()) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, arr[i]);
            } else {
                if(!map.get(c).equals(arr[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
