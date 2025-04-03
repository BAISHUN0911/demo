package org.example.infrastructure.collection;

import java.util.HashMap;

/**
 * HashMap存储数据时，会根据键的哈希码值将数据存储到数组中的特定位置
 * 默认初始容量是16，装载因子是0.75，当存储的数据大于初始容量乘装载因子时，会自动扩容
 * HashMap允许一个键为null，多个值为null
 * 无序，插入、删除和查找O(1)
 * 线程安全请使用ConcurrentHashMap
 * 扰动函数降低哈希冲突的概率
 * 哈希冲突解决思路：链表+红黑树，哈希桶存储链表头结点，多个key通过equals比较
 * 为什么树化阈值是8：泊松分布，哈希冲突达到8的概率极低
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


        int code1 = customHash(1);
        System.out.println("自定义哈希码：" + code1);

    }

    /**
     * 扰动函数
     * @return
     */
    private static int customHash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
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
