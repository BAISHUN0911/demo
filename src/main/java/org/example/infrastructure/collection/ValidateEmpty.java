package org.example.infrastructure.collection;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @description: 如何校验集合为空情况
 * @Author shengy
 * @Date 2025/1/10 18:17
 */
public class ValidateEmpty {
  @Data
  static class Demo {
    String name;
  }
  public static void main(String[] args) {
    List<Demo> summary = Arrays.asList(null, null);
    System.out.println(summary.size());
    System.out.println(summary.get(1));
    System.out.println(func(summary));
  }

  private static String func(List<Demo> summary) {
    if (!CollectionUtils.isEmpty(summary) && summary.size() > 1 && summary.get(1) != null){
      return Optional.ofNullable(summary.get(1).getName()).orElse("empty name");
    }
    return "empty name";
  }
}
