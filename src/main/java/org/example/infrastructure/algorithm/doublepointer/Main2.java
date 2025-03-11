package org.example.infrastructure.algorithm.doublepointer;

/**
 * 盛水最多的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i])
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
 * 给定数组[1,8,6,2,5,4,8,3,7] 找出索引为i,j的两个元素， 最多的水=面积最大= (j - i) * Min(arr[i], arr[j]) 最大
 *
 * @Author BAISHUN
 * @Date: 2024/5/23 15:36
 */
public class Main2 {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea2(arr));
    }

    /**
     * 两层for循环
     * 超时
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int area = -1;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i +1; j < height.length; j++) {
                area = Math.max((j - i) * Math.min(height[i], height[j]), area);
            }
        }
        return area;
    }

    /**
     *  |               |           初始指针分别在数组头尾，先移动arr[x]小的那一个指针
     * [1,8,6,2,5,4,8,3,7]
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = (right - left) * Math.min(height[left], height[right]);
        while (left != right) {
            if (height[left] <= height[right]) {
                left++;
            }else {
                right--;
            }
            area = Math.max((right - left) * Math.min(height[right], height[left]), area);
        }
        return area;
    }
}
