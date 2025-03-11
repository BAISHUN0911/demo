package org.example.infrastructure.algorithm.api;

/**
 * 字符包装类 Character
 *
 * @Author BAISHUN
 * @Date: 2024/7/10 16:37
 */
public class CharacterDemo {
    public static void main(String[] args) {
        System.out.println("判断字符'9'是否是数字：" + Character.isDigit('9'));
        System.out.println("判断字符's'是否是字母：" + Character.isLetter('s'));
        System.out.println("s是否是小写：" + Character.isLowerCase('s'));
        System.out.println("s是否是数字或字母：" + Character.isLetterOrDigit('s'));
    }
}
