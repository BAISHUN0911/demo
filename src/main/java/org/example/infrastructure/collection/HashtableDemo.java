package org.example.infrastructure.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @Author shengy
 * @Date 2025/8/1 10:49
 */
public class HashtableDemo {
  public static void main(String[] args) throws InterruptedException {
    // 线程安全。所有方法都加锁，导致并发性能较低
    Hashtable<String, String> hashtable = new Hashtable<>();
//    hashtable.put("1", "1");
//    hashtable.put("2", null);   // NullPointerException
//    hashtable.put(null, "3");     // Cannot invoke "Object.hashCode()" because "key" is null
    ExecutorService threadPool = Executors.newFixedThreadPool(10);

    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 1000; j++) {
        final String key = String.valueOf(j);
        threadPool.submit(() -> hashtable.put(key, "1"));
      }
    }
    Thread.sleep(2000);
    System.out.println("预期放入1k个元素，实际放入元素：" + hashtable.size());

    for (Map.Entry<String, String> entry : hashtable.entrySet()) {

    }

    HashMap<String, String> map = new HashMap<>();
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 1000; j++) {
        final String key = String.valueOf(j);
        threadPool.submit(() -> map.put(key, "1"));
      }
    }
    Thread.sleep(2000);
    System.out.println("预期放入1k个元素，实际放入元素：" + map.size());
    Set<String> keys = new HashSet<>();
    map.forEach((k, v) -> keys.add(k));
    System.out.println("去重后 Key 数量：" + keys.size());
    System.out.println("map.size()：" + map.size());


    threadPool.shutdown();
  }
}
