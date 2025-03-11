package org.example.scene.str;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 为数值加上千分位
 * @Author shengy
 * @Date 2024/10/21 11:09
 */
public class ThousandSeparator {
  public static void main(String[] args) {
    List<Long> list = Arrays.asList(1L, 10L, 100L, 1000L, 10000L,1000000L);
    System.out.println(addThousandSeparator(list));
  }

  private static List<String> addThousandSeparator(List<Long> list) {
    DecimalFormat df = new DecimalFormat("#,###");
    ArrayList<String> strings = new ArrayList<>();
    list.forEach(vo -> {
      try{
        strings.add(df.format(vo));
      } catch (NumberFormatException e) {
        e.printStackTrace();
      }
    });
    return strings;
  }
}
