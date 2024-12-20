package com.xc.tlias_web_management.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
@Order(1)//设置优先级 越小优先级越高
public class MyAspect1 {

/*
    @Pointcut("execution(* com.xc.tlias_web_management.service.DeptService.*(..))")
    public void pointcut() {
    }

    //@Before("execution(* com.xc.tlias_web_management.service.DeptService.*(..))")
    @Before("pointcut()")
    public void before() {
        log.info("before");
    }

    //@Around("execution(* com.xc.tlias_web_management.service.DeptService.*(..))")
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint process) throws Throwable {
        log.info("around");

        //执行方法
        Object result = process.proceed();

        //处理结果

        //返回结果
        return result;
    }

    //@After("execution(* com.xc.tlias_web_management.service.DeptService.*(..))")
    @After("pointcut()")
    public void after() {
         log.info("after");
    }

    //@AfterReturning("execution(* com.xc.tlias_web_management.service.DeptService.*(..))")
    @AfterReturning("pointcut()")
    public void afterReturning() {
        log.info("afterReturning");
    }


    //异常通知
    //@AfterThrowing("execution(* com.xc.tlias_web_management.service.DeptService.*(..))")
    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        log.info("afterThrowing");
    }*/
}
