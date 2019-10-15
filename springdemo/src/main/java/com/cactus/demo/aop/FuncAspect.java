package com.cactus.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by liruigao
 * Date: 2019-10-11 15:19
 * Description: 切面类
 * @Aspect 声明切面
 * @Component 声明Bean
 * @Pointcut 声明切点
 * @After 声明一个建言，并使用@Pointcut声明的切点。
 */

@Aspect
@Component
public class FuncAspect {

    // 使用注解拦截-start

    @Pointcut("@annotation(com.cactus.demo.aop.Action)")
    public void annotationPointCut(){};

    // 可通过反射获得注解上的属性，然后做自定义操作
    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("FuncAspect after, action name : " + action.name());
    }

    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("FuncAspect after, no operation, 注解式拦截");
    }

    // 使用注解拦截-end

    // 使用方法规则拦截-start

    @Before("execution(* com.cactus.demo.aop.FuncTwoService.*(..))")
    public void beforef(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则拦截-before， methodName:" + method.getName());
    }

    @After("execution(* com.cactus.demo.aop.FuncTwoService.*(..))")
    public void afterf(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则拦截-after， methodName:" + method.getName());
    }
    // 使用方法规则拦截-end
}
