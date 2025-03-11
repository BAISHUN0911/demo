package org.example.framework.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/6/4 22:55
 */
@Aspect
@Component
@Slf4j
public class DemoAspect {

    @Before("@annotation(org.example.framework.aop.DemoLog)")
    public void beforeMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        DemoLog annotation = method.getAnnotation(DemoLog.class);
        String operator = annotation.operator();
        log.info("Before executing method, current operator: {}", operator);
    }
}
