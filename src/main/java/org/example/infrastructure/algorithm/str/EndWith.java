package org.example.infrastructure.algorithm.str;

/**
 * 判断一个字符串 是否以 指定字符串 结尾
 *
 * @Author BAISHUN
 * @Date: 2024/7/8 22:58
 */
public class EndWith {
    public static void main(String[] args) {
        String str = "demo.txt";
        String suffix = "txt";
        System.out.println(endWith(str, suffix));
    }

    /**
     * 返回true代表给定字符串是以对应后缀结尾
     *
     * @param str 字符串
     * @param suffix 后缀
     * @return
     */
    private static boolean endWith(String str, String suffix) {
        int len1 = str.length();
        int len2 = suffix.length();
        if (len1 < len2) {
            return false;
        }
        String end = str.substring(len1 - len2, len1);
        return end.equals(suffix);
    }
}
