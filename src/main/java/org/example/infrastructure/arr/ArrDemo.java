package org.example.infrastructure.arr;

import java.util.Arrays;

/**
 * @description: 数组常用操作
 * @Author BAISHUN
 * @Date 2024/8/10 10:58
 */
public class ArrDemo {
    public static void main(String[] args) {
        int[] a = {100, 1, 2, 3};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        String s1 = "10000";
        String s2 = "1000";
        System.out.println(s1.compareTo(s2));

        int[] arr = new int[10];
        System.out.println(arr[9]);
    }
}
