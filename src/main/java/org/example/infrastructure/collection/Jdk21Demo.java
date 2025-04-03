package org.example.infrastructure.collection;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * @description: jdk21新特性
 * 1.通过SequencedCollection统一了首尾操作接口
 * @Author shengy
 * @Date 2025/4/3 11:24
 */
public class Jdk21Demo {

  public record Person(String name, int age) {
  }

  public static void main(String[] args) {
    List<String> list = List.of("A", "C", "B"); //Since:9
    System.out.println(list.getFirst());        //Since:21

    Person p1 = new Person("张三", 18);
    Person p2 = new Person("jack", 22);
    System.out.println("name: " + p1.name() + ", age: " + p1.age);

    String str = """
            {
              "name": "张三",
              "age": 18
            }
            """;

    // 不可变集合
    List<Person> personList = List.of(p1, p2);
//    personList.add(p1);    // 不可变集合，添加会报错
    // 增强Stream toList()
    List<String> nameList = personList.stream().map(Person::name).toList();

    // JDK 21：百万级轻量级线程
    try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
      executor.submit(() -> System.out.println(Thread.currentThread()));
    }
  }


}
