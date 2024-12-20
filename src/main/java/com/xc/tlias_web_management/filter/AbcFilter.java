package com.xc.tlias_web_management.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/*过滤器链
* 1. 过滤器链的执行顺序 由@WebFilter注解中的filterName属性值的字典顺序决定
* 2. 只有最后一个过滤器的doFilter方法中的filterChain.doFilter方法才会调用目标资源
* */


//@WebFilter("/*")
public class AbcFilter implements Filter {
    @Override // 过滤方法 每次请求时执行
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Abc doFilter放行前");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("Abc doFilter放行后");
    }
}
