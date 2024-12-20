package com.xc.tlias_web_management.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Slf4j
public class MyAnnotation {
    /*@Pointcut("@annotation(com.xc.tlias_web_management.aop.MyLog)")
    private void pointcut() {
    }

    @Before("pointcut()")
    public void before() {
        log.info("before");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint process) throws Throwable {

        //获取类名
        String className = process.getTarget().getClass().getName();

        //获取方法名
        String methodName = process.getSignature().getName();

        //获取参数
        Object[] args = process.getArgs();

        //放行 并且 获取返回值
        Object pc = process.proceed();

        return pc;
    }*/
}
