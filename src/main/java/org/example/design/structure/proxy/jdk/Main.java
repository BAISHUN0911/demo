package org.example.design.structure.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @description:
 * @Author shengy
 * @Date 2025/4/3 15:43
 */
public class Main {
  public static void main(String[] args) {
    Student student = new Student("jack");
    student.wakeup();
    JdkProxy proxy = new JdkProxy(new Student("张三"));
    /**
     * 只有实现了接口的类才能被JDK动态代理代理
     * 类加载器: proxy.getClass().getClassLoader()等效于 Student.class.getClassLoader()
     * 接口数组：在创建代理类时，需要指定一组接口，代理类将会实现这些接口。这意味着代理类可以伪装成任何实现了这些接口的类的实例。
     * InvocationHandler是一个接口，用于处理代理实例上的方法调用。当代理类的任何方法被调用时，都会被转发到InvocationHandler的invoke方法。
     */
    Person student2 = (Person) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), new Class[]{Person.class},
            proxy);
    student2.wakeup();
    student2.sleep();

    /**
     * CGLIB，它可以通过继承来创建代理类
     */
    CglibProxy cglibProxy = new CglibProxy(new Student("张三"));
    Student student3 = (Student) cglibProxy.getProxy();
    student3.wakeup();
    student3.sleep();
  }
}
