package com.xc.tlias_web_management.controller;

import com.xc.tlias_web_management.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SessionController {
    /*优缺点
    * 优点：cookie在浏览器是自带的，不需要额外的存储空间，不需要服务器存储，不需要服务器处理，不需要服务器的支持
    * 缺点：cookie容量有限，不安全，可以被篡改，可以被禁用，不同浏览器不共享，不同域名不共享
    * */

    //设置cookie
    @GetMapping("/cookie1")
    public Result cookie1(HttpServletResponse response) {
        response.addCookie(new Cookie("login_username", "xc"));
        return Result.success();
    }

    //获取cookie
    @GetMapping("/cookie2")
    public Result cookie2(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();//获取所有cookie
        for (Cookie cookie : cookies) {
            log.info("cookie: {}={}", cookie.getName(), cookie.getValue());
        }
        return Result.success();
    }



    /*优缺点
    * 优点：session存储在服务器端，安全，不会被篡改，不会被禁用，不会被禁用，不同浏览器共享，不同域名共享
    * 缺点：session需要服务器存储，需要服务器处理，需要服务器的支持
     */

    //设置session
    @GetMapping("/session1")
    public Result session1(HttpSession session) {
        log.info("HttpSession: {}", session.hashCode());

        session.setAttribute("loginUser", "xc");

        return Result.success();
    }

    //获取session
    @GetMapping("/session2")
    public Result session2(HttpServletRequest request) {
        HttpSession session = request.getSession();
        log.info("HttpSession: {}", session.hashCode());

        Object loginUser = session.getAttribute("loginUser");//获取session中的数据
        log.info("loginUser: {}", loginUser);

        return Result.success();
    }
}
