package org.example.infrastructure.algorithm.math;

public class ClockAngleCalculator {

    /**
     * 根据时 分 计算时针与分针小的夹角度数
     *
     */
    public static double calculate(int hour, int minute) {

        // 度数计算以12点为基准
        // 分针角度 = 分钟数 / 60 * 360 = 分钟数 * 6
        int mAngle = minute * 6;
        // 时针角度 = 小时数 / 12 * 360 + 分钟数 / 60 * 30 = 小时数 * 30 + 分钟数 * 0.5
        double hAngle = hour * 30 + minute * 0.5;

        // 获取夹角，夹角取绝对值
        double diff = Math.abs(hAngle - mAngle);

        // 夹角取绝对值后，如果大于180度，则夹角为360减去夹角，因为夹角越界了
        return Math.min(diff, 360 - diff);
    }

    public static void main(String[] args) {
        System.out.println(12 % 12);
        System.out.println(Math.abs(-1));
        System.out.println(calculate(9, 30));
        System.out.println(calculate(12, 30));
        System.out.println(calculate(12, 0));
    }
}
