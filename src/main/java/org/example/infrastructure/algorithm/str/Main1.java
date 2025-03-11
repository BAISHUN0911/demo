package org.example.infrastructure.algorithm.str;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 无重复字符的最长子串
 *
 * @Author BAISHUN
 * @Date: 2024/5/23 16:10
 */
public class Main1 {
    public static void main(String[] args) {
        String s = "bcaacbd";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 优选答案，通过HashMap
     * 注意：Map集合中元素的含义不是存储当前子串的所有元素值，而是记录出现过的字符及其对应的最新索引！
     * max值不依赖map集合大小，max值只根据left和right指针来计算
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                /** 注意更新left指针时需判断新值是否大于当前的left */
                left = Math.max(left, map.get(c) + 1);        // 出现过这个字符则更新left指针
            }
            map.put(c, right);      // 添加或更新指定字符 和对应的 索引值
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    /**
     * 两层for循环
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        char[] arr = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            set.add(arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                if (set.contains(arr[j])) {
                    max = Math.max(max, set.size());
                    set.clear();
                    break;
                }
                set.add(arr[j]);
            }
            max = Math.max(max, set.size());
            set.clear();
        }
        return max;
    }

    /**
     * 滑动窗口 双指针 + Set集合
     *  |  |
     * "abcabcbb"
     * “bcaacbd”
     * 注意特殊情况：空字符串“”  有一个空格“ ” 都不重复字符串“ab”
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        char[] arr = s.toCharArray();
        int left = 0;
        int right = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        set.add(arr[left]);
        while (right < arr.length -1) {
            right++;
            if (set.contains(arr[right])) {
                for (int i = left; i < right; i++) {
                    // 寻找重复元素之前的索引
                    if (arr[i] == arr[right]) {
                        max = Math.max(max, right - left);
                        // 更新left指针
                        left = i + 1;
                        break;
                    }
                }
            }else {
                set.add(arr[right]);
            }
        }
        return Math.max(max, right - left + 1);            // 这里不能通过set集合大小来判断，有歧义，应该通过left和right指针来计算
    }

}
