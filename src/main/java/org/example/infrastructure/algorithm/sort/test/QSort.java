package org.example.infrastructure.algorithm.sort.test;

/**
 * 快速排序
 *
 * @Author BAISHUN
 * @Date: 2024/6/13 15:50
 */
public class QSort {
    public static void main(String[] args) {
        int[] arr = {8, 7, 6, 4, 3, 5};
        int n = arr.length;

        System.out.println("Unsorted array:");
        printArray(arr);

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int index = partition(arr, left, right);
            quickSort(arr, left, index - 1);
            quickSort(arr, index + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int num = arr[right];
        // 这里设置为当前数组left左边一位
        int index = left - 1;
        for (int i = left; i < right; i++) {
            if (arr[i] < num) {
                swap(arr, ++index, i);
            }
        }
        swap(arr, ++index, right);
        return index;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
