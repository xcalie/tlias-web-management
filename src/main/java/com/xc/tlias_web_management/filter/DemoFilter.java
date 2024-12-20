package com.xc.tlias_web_management.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override // 初始化方法 服务器启动时执行 只调用一次
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("init初始化方法执行了");
    }

    @Override // 过滤方法 每次请求时执行
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter过滤方法执行了");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override // 销毁方法 服务器关闭时执行 只调用一次
    public void destroy() {
        Filter.super.destroy();
        System.out.println("destroy销毁方法执行了");
    }
}
