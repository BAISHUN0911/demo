package org.example.infrastructure.collection;

import java.util.*;

/**
 * 1.测试对HashMap中的key和value定制排序：按value降序排序，如果value相等按key升序排序
 * 大致思路：将HashMap中的entrySet转为List，然后使用Collections.sort()进行排序
 */
public class SortedMap01 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(20, 100);
        map.put(19, 200);
        map.put(10, 100);
        map.put(1, 1000);
        HashMap<Integer, Integer> sortedHashMap = sortHashMap(map);
        for (Map.Entry<Integer, Integer> entry : sortedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static HashMap<Integer, Integer> sortHashMap(HashMap<Integer, Integer> map) {
        ArrayList<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int compareValue = o2.getValue() - o1.getValue();
                return (compareValue == 0) ? o1.getKey() - o2.getKey() : compareValue;
            }
        });
        // LinkedHashMap保证元素插入顺序
        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
