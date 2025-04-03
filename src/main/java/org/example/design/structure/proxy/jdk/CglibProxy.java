package org.example.design.structure.proxy.jdk;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @Author shengy
 * @Date 2025/4/3 16:03
 */
public class CglibProxy implements MethodInterceptor {

  private Enhancer enhancer = new Enhancer();

  private Object bean;

  public CglibProxy(Object bean) {
    this.bean = bean;
  }

  public Object getProxy(){
    //设置需要创建子类的类
    enhancer.setSuperclass(bean.getClass());
    enhancer.setCallback(this);
    //通过字节码技术动态创建子类实例
    return enhancer.create();
  }
  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
    String methodName = method.getName();
    if (methodName.equals("wakeup")) {
      System.out.println("早安~~~");
    } else if (methodName.equals("sleep")) {
      System.out.println("晚安~~~");
    }

    //调用原bean的方法
    return method.invoke(bean, objects);
  }
}
