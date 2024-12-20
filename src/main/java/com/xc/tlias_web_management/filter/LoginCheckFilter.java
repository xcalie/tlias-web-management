package com.xc.tlias_web_management.filter;


import com.xc.tlias_web_management.pojo.Result;
import com.xc.tlias_web_management.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // 获取请求的URL
        String url = req.getRequestURL().toString();
        log.info("请求的URL: " + url);

        // 判断是否是登录页面
        if (url.contains("login")) {
            filterChain.doFilter(req, resp);
            return;
        }

        // 获取token
        String jwt = req.getHeader("token");

        // 判断是否存在，如果不存在，返回登录页面
        if (!StringUtils.hasLength(jwt)) {
            log.info("token不存在，返回登录页面");
            Result error = Result.error("NOT_LOGIN");
            //手动转换
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
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
            resp.getWriter().write(notLogin);
            return;
        }

        // 放行
        log.info("token验证通过，放行");
        filterChain.doFilter(req, resp);
    }
}
