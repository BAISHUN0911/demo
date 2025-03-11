package org.example.infrastructure.algorithm.sort;

/**
 * @description:
 * @Author shengy
 * @Date 2025/2/20 9:48
 */
public class Main {
  public static void main(String[] args) {
    int[] arr = { 1, 2, 5, 4, 3, 6, 7, 10, 9, 8 };
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - 1 - i; j++) {
        if (arr[j] > arr[j+1]) change(arr, j, j+1);
      }
    }

    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  private static void change(int[] arr, int j, int i) {
    int temp = arr[j];
    arr[j] = arr[i];
    arr[i] = temp;
  }
}
