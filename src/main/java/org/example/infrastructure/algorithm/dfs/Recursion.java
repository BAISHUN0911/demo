package org.example.infrastructure.algorithm.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * 递归示例代码
 *
 * @Author BAISHUN
 * @Date: 2024/6/19 11:23
 */
public class Recursion {
    public static void main(String[] args) {
        System.out.println(stepNums(5));
        System.out.println(stepNumsWithMap(5, new HashMap<>()));
        System.out.println(stepNumsNoRecursion(5));
    }

    /**
     * n阶台阶，每次只能走1阶或2阶，求总共有多少种方案
     *
     * @param n 台阶数
     * @return 总方案数
     */
    private static int stepNums(int n) {
        // 终止条件
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        // 每一步操作
        return stepNums(n - 1) + stepNums(n - 2);
    }

    /**
     * n阶台阶，每次只能走1阶或2阶，求总共有多少种方案。使用记忆散列表
     *
     * @param n 台阶数
     * @return 总方案数
     */
    private static int stepNumsWithMap(int n, Map<Integer, Integer> memo) {
        // 终止条件
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int steps = stepNumsWithMap(n - 1, memo) + stepNumsWithMap(n - 2, memo);
        memo.put(n, steps);
        // 每一步操作
        return steps;
    }

    private static int stepNumsNoRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; i++) {
            ret = pre + prepre;
            prepre = pre;           // 当i=3时，对于下一个4来讲，prepre代表f(2),pre代表f(3)
            pre = ret;
        }
        return ret;
    }
}
