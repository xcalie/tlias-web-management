package com.xc.tlias_web_management;

import com.xc.tlias_web_management.mapper.DeptMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.jdom2.output.Format.compact;

//@SpringBootTest
class TliasWebManagementApplicationTests {

    /*@Autowired
    private DeptMapper deptMapper;

    public void SelectAllDept() {
        System.out.println("查询全部部门的数据");
        System.out.println(deptMapper.list());
    }*/

    /**
     * 生成JWT
     */
    //@Test
    public void testGenJwt() {
        Map<String, Object> clams = new HashMap<>();
        clams.put("id", "1");
        clams.put("name", "xc");
        clams.put("roles", "admin");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "xcalieofwebxcalieofwebxcalieofwebxcalieofweb")
                .setClaims(clams)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .compact();

        System.out.println(jwt);
    }


    /**
     * 解析JWT
     */
    public void testParseJwt() {
        Claims claims = Jwts.parser()
                .setSigningKey("xcalieofwebxcalieofwebxcalieofwebxcalieofweb")
                .build()
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6ImFkbWluIiwibmFtZSI6InhjIiwiaWQiOiIxIiwiZXhwIjoxNzM0NjM4MDE3fQ.8MLTELHXhoER1jw71I8PQyp4yPBJI6tTQZZ2AqO73RE")
                .getBody();
        System.out.println(claims);
    }


}
