package com.xc.tlias_web_management.config;

import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//标注为配置类
public class CommonConfig {

    //申明第三方bean
    @Bean   //将第三方bean注入到spring容器
            //Bean的名字默认为方法名
            //可以通过@Bean("beanName")来指定bean的名字
    public SAXReader saxReader(){
        return new SAXReader();
    }

    //如果在参数中传入bean，spring会自动注入
}
