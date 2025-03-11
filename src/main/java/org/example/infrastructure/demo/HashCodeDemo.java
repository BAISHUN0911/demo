package org.example.infrastructure.demo;

/**
 * @Author BAISHUN
 * @Date: 2024/5/8 22:24
 */
public class HashCodeDemo {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = new String("abc");
        System.out.println("abc的hashCode: " + str1.hashCode());
        System.out.println("str2的hashCode: " + str2.hashCode());
        compare1();
    }

    /**
     * 字符串应该使用equals方法去比较，而不能用==
     */
    private static void compare1() {
        String s1 = new String("hello");
        String s2 = new String("hello");
        String s3 = "hello";
        System.out.println(s1 == s3);
        // 通过 == 比较引用，返回 true，因为都是不同的对象，但内容相同
        System.out.println(s1 == s2); // 输出 true
        // 通过 equals() 比较内容，返回 true，内容相同
        System.out.println(s1.equals(s2)); // 输出 true
    }
}
