package org.example.infrastructure.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/5/20 14:35
 */
public class ListDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("BA");
        list.add("AB");
        list.add("123");
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        Iterator<String> iterator = list.iterator();

        // 数组扩容
        int[] arr = {1, 2, 3};
        int[] newArr = Arrays.copyOf(arr, 4);
        System.out.println(Arrays.toString(newArr));
    }
}
