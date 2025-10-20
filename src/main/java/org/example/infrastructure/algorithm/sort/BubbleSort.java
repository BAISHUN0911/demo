package org.example.infrastructure.algorithm.sort;

import java.util.Arrays;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/6/12 23:06
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        int[] sorted = bubbleSort(arr);
        System.out.println(Arrays.toString(sorted));
    }

    /**
     * 两层for循环，时间复杂度O(n2)
     * 外层i代表冒泡次数，n-1次即可
     * 内层的j最大值情况：第一次遍历：arr.length - 2，因为需要防止数组索引【j+1】越界
     * 内层的j最小值 = 1，最后一次遍历只需要比较arr[0]和arr[1]即可，所以i最大为arr.length - 2
     *
     * @param arr 待排序数组
     * @return 排序后数组
     */
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
