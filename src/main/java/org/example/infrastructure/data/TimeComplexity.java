package org.example.infrastructure.data;

/**
 * 不同时间复杂度的示例代码
 *
 * @Author BAISHUN
 * @Date: 2024/6/18 16:53
 */
public class TimeComplexity {
    public static void main(String[] args) {
        System.out.println("时间复杂度O(1) " + o1());
        System.out.println("时间复杂度O(logn) " + logn(64));
        System.out.println("时间复杂度O(m+n) " + mAddN(10, 10));
    }

    /**
     * 时间复杂度受m、n共同影响
     *
     * @param m m系数
     * @param n n系数
     * @return 结果
     */
    private static int mAddN(int m, int n) {
        int sum1 = 0;
        for (int i = 0; i < m; i++) {
            sum1 = sum1 + i;
        }
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum2 = sum2 + i;
        }
        return sum1 + sum2;
    }

    /**
     * 计算数字1需要乘以多少次2才能等于n，如果能通过乘以2得到n则返回次数，否则返回-1
     *
     * @param n 目标值
     * @return 乘法次数
     */
    private static int logn(int n) {
        int i = 1;
        int sum = 0;
        while (i < n) {
            i = i * 2;
            sum ++;
        }
        if (i == n) {
            return sum;
        }
        return -1;
    }

    private static int o1() {
        int i = 7;
        int j = 1;
        int sum = 0;
        for(int k = 0; k < 100; k++) {
            sum += i + j;
        }
        return sum;
    }
}
