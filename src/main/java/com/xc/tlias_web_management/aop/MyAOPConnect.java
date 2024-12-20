package com.xc.tlias_web_management.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class MyAOPConnect {
/*
    @Pointcut("execution(* com.xc.tlias_web_management.service.DeptService.*(..))")
    private void pointcut() {
    }

    @Before("pointcut()")
    public void before() {
        log.info("before");
    }

    @Around("pointcut()")
    public void around() {
        log.info("around");
    }*/
}
