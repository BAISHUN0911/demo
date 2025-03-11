package org.example.infrastructure.algorithm.sort;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/6/12 23:27
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 9, 1, 5};
        int n = arr.length;

        System.out.println("Unsorted array:");
        printArray(arr);

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    /**
     * 如果左边界小于右边界则代表需要排序
     *
     * @param arr 待排序数组
     * @param left 左边界
     * @param right 右边界
     */
    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // 第一次对数组进行分区，这一步操作后选取的基准值左边的元素都比基准值小，右边的都比基准值大
            int index = partition(arr, left, right);
            // 对小的那部分进行排序，递归
            quickSort(arr, left, index - 1);
            // 对大的那部分进行排序
            quickSort(arr, index + 1, right);
        }
    }

    /**
     * 分区操作，将比基准值小的放在基准值左边，比基准值大的放在基准值右边
     *
     * @param arr 数组
     * @param left 左边界
     * @param right 右边界
     * @return 本次分区后基准值所在索引
     */
    private static int partition(int[] arr, int left, int right) {
        // 选择最右边的元素为基准元素
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                // 当前元素小于基准元素
                i++;    // i代表上一次交换的记录，-1代表没有发生过交换
                // 交换索引i 与 索引j
                swap(arr, i, j);
            }
        }
        // 这一步交换后就实现了比基准值小的都在其左边，比基准值大的都在其右边
        swap(arr, i + 1, right);
        // 返回基准值所在的索引
        return i + 1;
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
