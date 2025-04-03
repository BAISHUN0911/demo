package org.example.design.structure.proxy.jdk;

/**
 * @description:
 * @Author shengy
 * @Date 2025/4/3 15:39
 */
public class Student implements Person{

  private String name;

  public Student() {
  }

  public Student(String name) {
    this.name = name;
  }

  @Override
  public void wakeup() {
    System.out.printf("学生[%s]早晨醒来啦%n", name);
  }

  @Override
  public void sleep() {
    System.out.printf("学生[%s]晚上睡觉啦",name);
  }
}
