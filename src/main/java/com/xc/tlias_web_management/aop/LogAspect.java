package com.xc.tlias_web_management.aop;

import com.xc.tlias_web_management.pojo.OperateLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.xc.tlias_web_management.aop.MyLog)")
    private void LApc() {
    }

    @Around("LApc()")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();

        OperateLog logOf = new OperateLog();

        // 获取操作人ID



        return result;
    }
}
