package com.xc.tlias_web_management.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.xc.tlias_web_management.pojo.Result;
import com.xc.tlias_web_management.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.net.AbstractEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override//重写preHandle方法 true放行 false拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求的URL
        String url = request.getRequestURL().toString();
        log.info("请求的URL: " + url);

        // 判断是否是登录页面
        if (url.contains("login")) {
            log.info("请求的是登录页面，放行");
            return true;
        }

        // 获取token
        String jwt = request.getHeader("token");

        // 判断是否存在，如果不存在，返回登录页面
        if (!StringUtils.hasLength(jwt)) {
            log.info("token不存在，返回登录页面");
            Result error = Result.error("NOT_LOGIN");
            //手动转换
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        // 解析token 如果失败，返回登录页面
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("token解析失败，返回登录页面");
            Result error = Result.error("NOT_LOGIN");
            //手动转换
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        // 放行
        log.info("token验证通过，放行");
        return true;
    }

}
