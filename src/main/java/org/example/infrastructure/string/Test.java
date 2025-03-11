package org.example.infrastructure.string;

import lombok.Getter;
import lombok.Setter;
import org.example.infrastructure.demo.IDemo1;

import java.util.Arrays;
import java.util.List;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/5/20 14:09
 */
public class Test implements IDemo1 {
  static class DemoStr {
    @Getter
    @Setter
    String str;

    public DemoStr(String str) {
      this.str = str;
    }

    @Override
    public String toString() {
      return "DemoStr{" +
              "str='" + str + '\'' +
              '}';
    }
  }

  public static void main(String[] args) {
//        IDemo1 demo = new Demo();
//        demo.hello();
//        IDemo1 test = new Test();
//        test.hello();

    DemoStr d1 = new DemoStr("性别未知");
    DemoStr d2 = new DemoStr("年龄未知");
    DemoStr d3 = new DemoStr("未1知");
    List<DemoStr> list = Arrays.asList(d1, d2, d3);
    list.forEach(e -> {
      if (e.getStr().contains("未知")) {
        e.setStr("未知");
      }
    });
    System.out.println(list);
  }
}
