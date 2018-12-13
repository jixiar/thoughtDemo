package com.dcml.cms.controller;

import org.aspectj.weaver.ast.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TestConfiguration {

    public TestConfiguration(){
        System.out.println("容器初始化！");
    }

    @Bean
    @Scope("prototype")
    public People test(){
        return new People();
    }

}
