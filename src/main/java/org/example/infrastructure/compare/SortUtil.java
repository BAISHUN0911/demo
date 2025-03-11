package org.example.infrastructure.compare;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * @description: 获取Comparator比较器工具
 * @Author shengy
 * @Date 2025/3/6 17:35
 */
public class SortUtil {
  /**
   * 获取自定义顺序的比较器
   *
   * @param order        定义排序顺序的列表
   * @param keyExtractor 提取属性值的函数
   * @param <T>          DTO对象类型
   * @return 自定义顺序的比较器
   */
  public static <T> Comparator<T> getCustomOrderComparator(List<String> order, Function<T, String> keyExtractor) {
    return Comparator.comparingInt(o -> {
      int index = order.indexOf(keyExtractor.apply(o));
      return index == -1 ? Integer.MAX_VALUE : index;
    });
  }

  private static <T> List<T> sortList(List<T> list, Comparator<T> comparator) {
    Objects.requireNonNull(list, "List must not be null");
    Objects.requireNonNull(comparator, "Comparator must not be null");
    List<T> sortedList = new ArrayList<>(list);
    sortedList.sort(comparator);
    return sortedList;
  }

  @Data
  @AllArgsConstructor
  static
  class Demo1 {
    private String type;

    private String value;
  }

  @Data
  @AllArgsConstructor
  static
  class Demo2 {
    private String type;

    private String value;
  }

  public static void main(String[] args) {
    List<String> ageOrder = Arrays.asList("<18", "18-24", "30-40", "24-30");
    List<Demo1> list1 = Arrays.asList(new Demo1("age", "24-30"),
            new Demo1("age", "30-40"),
            new Demo1("age", "18-24"),
            new Demo1("age", "<18"));
    Comparator<Demo1> comparator = SortUtil.getCustomOrderComparator(ageOrder, Demo1::getValue);
    List<Demo1> sortedList = SortUtil.sortList(list1, comparator);
    list1.forEach(System.out::print);
    System.out.println("=======");
    sortedList.forEach(System.out::println);
  }
}
