package com.xc.tlias_web_management.exception;

import com.xc.tlias_web_management.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result ex(Exception ex) {;
        ex.printStackTrace();
        return Result.error("对不起，服务器开小差了");
    }
}
