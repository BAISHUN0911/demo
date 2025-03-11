package org.example.infrastructure.algorithm.doublepointer;

/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 *
 * @Author BAISHUN
 * @Date: 2024/5/23 11:14
 */
public class Main1 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,0,2};
        moveZeroes2(arr);
    }

    /**
     * 思路1：遍历数组，遇到元素为0则与下一个非0元素交换位置，如果找不到则代表重排序完成。[1,0,0,0,1,2] ->[1,1,0,0,0,2] ->[1,1,2,0,0,0]   【0,1,1】
     * 优化 1.j从i+1开始遍历 2.如果arr[j]被交换了证明就结束了
     * @param nums 目标数组
     */
    public static void moveZeroes(int[] nums) {
        int flag = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (flag == 1) {
                break;
            }
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        swap(i, j, nums);
                        if (j == nums.length - 1) {
                            flag = 1;
                        }
                        break;
                    }
                }
            }
        }
    }

    /**
     * 使用双指针，左指针指向已处理好的尾部，右指针指向待处理的 头部
     *    左    右      右指针向右移动找非零元素，左指针指向第一个0，每次交换后左指针右移一个
     * [1,0,0,0,1,2]
     *
     *特殊情况
     * [1,1,1,1,0,2]  前面四个1每次都要自己交换自己，[0,1,1,1,1,0,1]
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(left, right, nums);
                left ++;
            }
            right ++;
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
