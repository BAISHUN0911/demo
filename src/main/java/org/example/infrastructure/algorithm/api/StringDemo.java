package org.example.infrastructure.algorithm.api;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/7/10 16:48
 */
public class StringDemo {
    public static void main(String[] args) {
        String str = " a  b c   ";
        System.out.println("将字符串分割为字符串数组str.split()");
        // 一个或多个空格进行分割，会出现结果数组第一个元素为""
        String[] arr = str.split("\\s+");
        System.out.println("当前arr数组" + Arrays.toString(arr));
        System.out.println("通过Arrays获取数组对应的stream流，然后filter过滤，然后toArray转为指定数组");
        String[] array = Arrays.stream(arr).filter(s -> !"".equals(s)).toArray(String[]::new);
        System.out.println("使用Arrays.toString(array)打印数组" + Arrays.toString(array));

        System.out.println("字符串截取\"abcd\".substring(1, 2): " + "abcd".substring(1, 2));

        System.out.println("indexOf()返回指定字符串在主字符串最先出现的索引：" + "aababab".indexOf("ab"));

        System.out.println("根据索引获取指定字符串的字符char，\"abcd\".charAt(1)：" + "abcd".charAt(1));

        System.out.println("compareTo比较，每个位置对应字符的ASCII值相减，长度不同返回差值");
        System.out.println("\"bca\".compareTo(\"a\")= " + "bca".compareTo("a"));
        System.out.println("\"acc\".compareTo(\"a\")= " + "acc".compareTo("a"));

        System.out.println("contains判断字符串中是否包含另一个字符串：" + "cabab".contains("ab"));

        String filename = "music.1.2.mp3";
        System.out.println("返回指定字符在字符串最后一次出现的索引:" + filename.substring(filename.lastIndexOf(".")));

        System.out.println("replace替换字符串中出现的指定字符或串为新的，replaceAll可传入一个正则表达式");
        String newStr = "abcdabcd".replace("abc", "x");
        String newStr2 = "12a34b5c".replaceAll("[0-9][0-9]", "x");
        System.out.println(newStr);
        System.out.println(newStr2);

        System.out.println("使用StringBuilder来高效拼接字符串");
        String str2 = "abcd";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < str2.length() - 1; i++) {
            sb.append(str2.charAt(i));
            sb.append("-");
        }
        sb.append(str2.charAt(i));
        System.out.println(sb);

        System.out.println("使用StringJoiner来构造指定分隔符分隔的字符序列");
        StringJoiner stringJoiner = new StringJoiner("-");
        for (int j = 0; j < str2.length(); j++) {
            stringJoiner.add(String.valueOf(str2.charAt(j)));
        }
        System.out.println(stringJoiner);

    }
}
