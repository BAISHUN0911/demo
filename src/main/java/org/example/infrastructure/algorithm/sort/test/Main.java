package org.example.infrastructure.algorithm.sort.test;

import java.util.Arrays;

/**
 * @description: 测试
 * @Author BAISHUN
 * @Date 2024/8/16 14:58
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 10, 4, 20, 7};
        sortArr(arr);
    }

    private static void sortArr(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
