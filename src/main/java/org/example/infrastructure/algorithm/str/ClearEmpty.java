package org.example.infrastructure.algorithm.str;

import java.util.Arrays;

/**
 * 删除一个String[]数组中为“”的元素
 *
 * @Author BAISHUN
 * @Date: 2024/7/10 17:08
 */
public class ClearEmpty {
    public static void main(String[] args) {
        String[] arr = {"1", "apple", "", "orange", ""};
        System.out.println(Arrays.toString(arr));
        System.out.println("当前数组大小：" + arr.length);
        clearEmpty(arr);

        System.out.println(Arrays.toString(arr));
        System.out.println("当前数组大小：" + arr.length);

        String[] resArr = clearEmptyByStream(arr);
        System.out.println(Arrays.toString(resArr));
        System.out.println("当前数组大小：" + resArr.length);
    }

    private static String[] clearEmptyByStream(String[] arr) {
        return Arrays.stream(arr).filter(s -> !"".equals(s)).toArray(String[]::new);
    }

    /**
     * 这种修改原数组的方法并不会改变数组大小，最终数组中仍存在""元素
     * 想要最终数组只存在非""元素则需要 新建数组保留过滤后的结果
     *
     * @param arr
     */
    private static void clearEmpty(String[] arr) {
        // 使用循环遍历原数组，删除空元素
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].isEmpty()) {
                arr[count++] = arr[i];
            }
        }
        // 将多余的部分置空
        while (count < arr.length) {
            arr[count++] = "";
        }
    }

}
