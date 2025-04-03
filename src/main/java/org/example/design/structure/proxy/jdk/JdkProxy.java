package org.example.design.structure.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description: jdk动态代理
 * @Author shengy
 * @Date 2025/4/3 15:44
 */
public class JdkProxy implements InvocationHandler {
  private Object bean;

  public JdkProxy(Object bean) {
    this.bean = bean;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    String methodName = method.getName();
    if (methodName.equals("wakeup")){
      System.out.println("早安~~~");
    }else if(methodName.equals("sleep")){
      System.out.println("晚安~~~");
    }

    return method.invoke(bean, args);
  }
}
