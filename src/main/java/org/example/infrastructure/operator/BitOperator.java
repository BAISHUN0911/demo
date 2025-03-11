package org.example.infrastructure.operator;

import java.text.DecimalFormat;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/5/22 23:12
 */
public class BitOperator {

    private static final int num = 0x100;

    private static final int HASH_INCREMENT = 0x61c88647;

    public static void main(String[] args) {
        int a = 10; // 1010
        int b = 12; // 1100
        System.out.println(a ^ b);      // 0110  6 按位异或，对应为相同则为0
        System.out.println(a & b);      // 按位与 1000 8
        System.out.println(a | b);      // 按位或 1110 14 对应位有一个1则为1

        System.out.println(num);
        System.out.println("0x61c88647= " + HASH_INCREMENT);

        // 计算斐波那契散列增量
        long maxNum = 1L << 32;
        System.out.println("maxNum = " + maxNum);
        double goldenRatio = 0.6180339887;
        System.out.println("goldenRatio = " + goldenRatio);

        DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(3);
        double result = maxNum * goldenRatio;
        int intRes = (int) result;
        System.out.println("result = " + df.format(result));
        System.out.println("intRes = " + intRes);
    }
}
