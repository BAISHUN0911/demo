package org.example.infrastructure.algorithm.api;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/7/10 15:33
 */
public class MathDemo {
    public static void main(String[] args) {
        // log返回目标值的自然对数，目标值需要时double类型
        System.out.println("log以2为底4的对数 = " + Math.log(4.0) / Math.log(2.0));
        // 向下取整
        System.out.println("Math.floor(3.14) = " + Math.floor(3.14));
        System.out.println("Math.floor(-3.14) = " + Math.floor(-3.14));
        // 向上取整
        System.out.println("Math.ceil(3.14) = " + Math.ceil(3.14));
        System.out.println("Math.ceil(-3.14) = " + Math.ceil(-3.14));

        System.out.println("2的3次方= " + Math.pow(2.0, 3.0));

        System.out.println("-2.1的绝对值 = " + Math.abs(-2.1));

        System.out.println("随机值：" + Math.random());
    }
}
