package org.example.infrastructure.collection;

import java.util.HashMap;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/7/2 15:46
 */
public class HashMapDemo {
    public static void main(String[] args) {
        // 初始默认容量是16
        HashMap<Integer, String> map = new HashMap<>();
        map.put(11, "jack");
        System.out.println("HashMap当前存储的元素数量：" + map.size());

        // 设置初始容量为16，装载因子为0.7
        HashMap<String, String> map1 = new HashMap<>(16, 0.7F);

        moveRightByBit();

    }

    /**
     * 测试按位右移>> 和 >>> 的区别
     */
    private static void moveRightByBit() {
        int i = 10;     // 1010
        int res = 0;
        res = i >>> 2;
        System.out.println("10>>>2= " + res);    // 0010
        res = i >> 2;
        System.out.println("10>>2= " + res);
        System.out.println("对于正数，>>和>>>得到的结果一样");
        i = -10;
        res = i >> 2;
        System.out.println("-10>>2= " + res);
        res = i >>> 2;
        System.out.println("-10>>>2= " + res);
        System.out.println("对于负数，>>保留符号位，>>>不保留符号位");
    }
}
