package com.xc.tlias_web_management.aop;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.xc.tlias_web_management.mapper.OperateLogMapper;
import com.xc.tlias_web_management.pojo.OperateLog;
import com.xc.tlias_web_management.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Pointcut("@annotation(com.xc.tlias_web_management.aop.MyLog)")
    private void LApc() {
    }

    @Around("LApc()")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        //操作员ID
        //获取JWT中的用户ID
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        Integer operateUser = Integer.parseInt(claims.getId());

        //操作时间
        //获取当前时间
        LocalDateTime operateTime = LocalDateTime.now();

        //操作类名
        String className = joinPoint.getTarget().getClass().getName();

        //操作方法名
        String methodName = joinPoint.getSignature().getName();

        //操作方法参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);

        //执行操作
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        //操作方法返回值
        String returnValue = JSONObject.toJSONString(result);

        //操作耗时
        long costTime = end - start;

        //封装日志数据
        OperateLog log = new OperateLog(null, operateUser, operateTime, className, methodName, methodParams, returnValue, costTime);

        //插入日志数据
        operateLogMapper.insert(log);

        return result;
    }
}
