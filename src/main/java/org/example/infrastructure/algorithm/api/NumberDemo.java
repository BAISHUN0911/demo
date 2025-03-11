package org.example.infrastructure.algorithm.api;

/**
 * 数字包装类的使用
 *
 * @Author BAISHUN
 * @Date: 2024/7/10 16:10
 */
public class NumberDemo {
    public static void main(String[] args) {
        Integer integer = 1010;
        String str = "1010";
        System.out.println("parseInt(str)将字符串转为int类型：" + Integer.parseInt(str));
        System.out.println("使用radix参数指定基数，例如str是2进制格式：parseInt(str, 2)  = " + Integer.parseInt(str, 2)
        + ", parseInt(\"FF\", 16)  = " + Integer.parseInt("FF", 16));
        System.out.println("int类型的最大值 = " + Integer.MAX_VALUE);
        System.out.println("比较两个数，左边小于右边返回-1:" + Integer.compare(1, 2));
        System.out.println("实例方法，将Integer类型转为double类型：" + integer.doubleValue());
        Long l1 = new Long(100);
        Long l2 = new Long(100);
        Long l3 = 100L;
        System.out.println(l1 == l2);
        System.out.println(l1 == l3);

    }
}
