package com.xc.tlias_web_management.controller;

import com.xc.tlias_web_management.pojo.Emp;
import com.xc.tlias_web_management.pojo.Result;
import com.xc.tlias_web_management.service.EmpService;
import com.xc.tlias_web_management.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.Jar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录控制器
 */
@Slf4j
@RequestMapping("/login")
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    /**
     * 登录
     * @param emp
     * @return
     */
    @PostMapping
    public Result login(@RequestBody Emp emp) {
        log.info("登录: {}", emp);

        //调用登录的业务逻辑
        Emp loginEmp = empService.login(emp);

        //登陆成功 就下方令牌
        if (loginEmp != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginEmp.getId());
            claims.put("name", loginEmp.getName());
            claims.put("username", loginEmp.getUsername());

            String jwt = JwtUtils.generateJwt(claims);

            return Result.success(jwt);
        }
        return Result.error("登录失败");

        //return loginEmp != null ? Result.success() : Result.error("登录失败");
    }
}
