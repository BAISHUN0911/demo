package org.example.infrastructure.string;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/5/20 13:58
 */
public class StringDemo {
    public static void main(String[] args) {
        String s1 = "\\\\";  // 反斜杠是转义字符，两个反斜杠代表一个反斜杠
        System.out.println(s1);
        String s2 = "abc";
        s2 = "ab";

        String s3 = "{";
        String s4 = "{}";
        System.out.println(s4.substring(1,s4.length()-1));
//        System.out.println(s3.substring(1,s3.length()-1));
    }
}
